package com.xiaomi.util;

public class IsValidate {

	public boolean isValidate(String code, String inCode) {

		int reCode = Integer.parseInt(code);
		int reInCode = Integer.parseInt(inCode);

		if (reCode == reInCode) {
			return true;
		}
		return false;

	}

}
