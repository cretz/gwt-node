package org.gwtnode.examples.scimark.impl;

import java.util.Properties;

import org.gwtnode.core.node.process.Process;

import com.google.gwt.core.client.GWT;

/**
	SciMark2: A Java numerical benchmark measuring performance
	of computational kernels for FFTs, Monte Carlo simulation,
	sparse matrix computations, Jacobi SOR, and dense LU matrix
	factorizations.  


*/

@SuppressWarnings("all")
public class commandline
{

  /* Benchmark 5 kernels with individual Mflops.
	 "results[0]" has the average Mflop rate.

  */


	public static void main(String args[])
	{
		// default to the (small) cache-contained version

		double min_time = Constants.RESOLUTION_DEFAULT;

		int FFT_size = Constants.FFT_SIZE;
		int SOR_size =  Constants.SOR_SIZE;
		int Sparse_size_M = Constants.SPARSE_SIZE_M;
		int Sparse_size_nz = Constants.SPARSE_SIZE_nz;
		int LU_size = Constants.LU_SIZE;

		// look for runtime options

        if (args.length > 0)
        {

			if (args[0].equalsIgnoreCase("-h") || 
						args[0].equalsIgnoreCase("-help"))
			{
				Process.get().stdout().write("Usage: [-large] [minimum_time]\n");
				return;
			}

			int current_arg = 0;
			if (args[current_arg].equalsIgnoreCase("-large"))
			{
				FFT_size = Constants.LG_FFT_SIZE;
				SOR_size =  Constants.LG_SOR_SIZE;
				Sparse_size_M = Constants.LG_SPARSE_SIZE_M;
				Sparse_size_nz = Constants.LG_SPARSE_SIZE_nz;
				LU_size = Constants.LG_LU_SIZE;

				current_arg++;
			}

			if (args.length > current_arg)
        		min_time = Double.valueOf(args[current_arg]).doubleValue();
        }
        

		// run the benchmark

		double res[] = new double[6];
		Random R = new Random(Constants.RANDOM_SEED);

		res[1] = kernel.measureFFT( FFT_size, min_time, R);
		res[2] = kernel.measureSOR( SOR_size, min_time, R);
		res[3] = kernel.measureMonteCarlo(min_time, R);
		res[4] = kernel.measureSparseMatmult( Sparse_size_M, 
					Sparse_size_nz, min_time, R);
		res[5] = kernel.measureLU( LU_size, min_time, R);


		res[0] = (res[1] + res[2] + res[3] + res[4] + res[5]) / 5;


	    // print out results

		Process.get().stdout().write("\n");
		Process.get().stdout().write("SciMark 2.0a\n");
		Process.get().stdout().write("\n");
		Process.get().stdout().write("Composite Score: " + res[0] + "\n");
		Process.get().stdout().write("FFT ("+FFT_size+"): ");
		if (res[1]==0.0)
		    Process.get().stdout().write(" ERROR, INVALID NUMERICAL RESULT!\n");
		else
		    Process.get().stdout().write(res[1] + "\n");

		Process.get().stdout().write("SOR ("+SOR_size+"x"+ SOR_size+"): "
				+ "  " + res[2] + "\n");
		Process.get().stdout().write("Monte Carlo : " + res[3] + "\n");
		Process.get().stdout().write("Sparse matmult (N="+ Sparse_size_M+ 
				", nz=" + Sparse_size_nz + "): " + res[4] + "\n");
		Process.get().stdout().write("LU (" + LU_size + "x" + LU_size + "): ");
		if (res[5]==0.0)
		    Process.get().stdout().write(" ERROR, INVALID NUMERICAL RESULT!\n");
		else
		    Process.get().stdout().write(res[5] + "\n");

		// print out System info
		Process.get().stdout().write("\n");
		Process.get().stdout().write("java.vendor: Google Web Toolkit\n");
		Process.get().stdout().write("java.version: ?\n");
		Process.get().stdout().write("os.arch: js\n");
		Process.get().stdout().write("os.name: node.js\n");
		Process.get().stdout().write("os.version: " +
		        Process.get().version() + "\n");


	}
  
}
