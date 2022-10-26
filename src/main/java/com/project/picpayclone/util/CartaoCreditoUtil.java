package com.project.picpayclone.util;

public class CartaoCreditoUtil {

	public static String mascarar(String numeroCartao) {
		return numeroCartao.replaceAll("\\b(\\d{4})(\\d{8})(\\d{4})", "$1xxxxxxxx$3");
	}
}
