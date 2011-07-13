global.${objectName} = { };
global.${objectName}.${classesName} = { };
global.${objectName}.${methodsName} = { };
global.${objectName}.${fieldsName} = { };

global.${objectName}._add = function(symbolData) {
	if (symbolData.isClass) {
		global.${objectName}.${classesName}[symbolData.className] = symbolData;
	} else if (symbolData.isMethod) {
		if (!global.${objectName}.${methodsName}[symbolData.className]) {
			global.${objectName}.${methodsName}[symbolData.className] = { };
		}
		global.${objectName}.${methodsName}[symbolData.className][symbolData.memberName] = symbolData;
	} else if (symbolData.isField) {
		if (!global.${objectName}.${fieldsName}[symbolData.className]) {
			global.${objectName}.${fieldsName}[symbolData.className] = { };
		}
		global.${objectName}.${fieldsName}[symbolData.className][symbolData.memberName] = symbolData;
	}
}