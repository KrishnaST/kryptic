package org.kryptic.dataconverter;

import java.util.HashMap;

public class ByteHexUtil {

	private static final char[] hexCode = "0123456789ABCDEF".toCharArray();
	private static byte[] hexToByteTable = new byte['f'+1];
	
	private static HashMap<String, Byte> hexToByteMap = new HashMap<>();
	
	public static int hexToByte(char ch) {
		if ('0' <= ch && ch <= '9') return ch - '0';
		if ('A' <= ch && ch <= 'F') return ch - 'A' + 10;
		if ('a' <= ch && ch <= 'f') return ch - 'a' + 10;
		return -1;
	}
	
	public static byte hexPairToByte(String hexString) {
		int h = hexToByte(hexString.charAt(0));
		int l = hexToByte(hexString.charAt(1));
		if (h == -1 || l == -1) throw new IllegalArgumentException("contains illegal character for hexBinary: " + hexString);
		byte byteValue = (byte) (h * 16 + l);
		return byteValue;
	}
	
	static {
		hexToByteTable['0']  = 0;
		hexToByteTable['1']  = 1;
		hexToByteTable['2']  = 2;
		hexToByteTable['3']  = 3;
		hexToByteTable['4']  = 4;
		hexToByteTable['5']  = 5;
		hexToByteTable['6']  = 6;
		hexToByteTable['7']  = 7;
		hexToByteTable['8']  = 8;
		hexToByteTable['9']  = 9;
	
		hexToByteTable['A']  = 10;
		hexToByteTable['B']  = 11;
		hexToByteTable['C']  = 12;
		hexToByteTable['D']  = 13;		
		hexToByteTable['E']  = 14;
		hexToByteTable['F']  = 15;
		
		hexToByteTable['a']  = 10;
		hexToByteTable['b']  = 11;
		hexToByteTable['c']  = 12;
		hexToByteTable['d']  = 13;		
		hexToByteTable['e']  = 14;
		hexToByteTable['f']  = 15;
		
		for(int i = 0; i<hexCode.length; i++){
			for(int k = 0; k<hexCode.length; k++){
				System.out.println((hexCode[i]+""+hexCode[k]).hashCode());
				hexToByteMap.put(hexCode[i]+""+hexCode[k], hexPairToByte(hexCode[i]+""+hexCode[k]));
			}
		}
		
		
	}
	
	private static final String[] byteToHexTable = new String[]
	{
	    "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F",
	    "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F",
	    "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F",
	    "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F",
	    "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F",
	    "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F",
	    "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F",
	    "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F",
	    "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F",
	    "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F",
	    "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF",
	    "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF",
	    "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF",
	    "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF",
	    "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF",
	    "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"
	};
	
	private static final String[] byteToHexTableLowerCase = new String[]
	{
	    "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0a", "0b", "0c", "0d", "0e", "0f",
	    "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1a", "1b", "1c", "1d", "1e", "1f",
	    "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2a", "2b", "2c", "2d", "2e", "2f",
	    "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3a", "3b", "3c", "3d", "3e", "3f",
	    "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4a", "4b", "4c", "4d", "4e", "4f",
	    "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5a", "5b", "5c", "5d", "5e", "5f",
	    "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6a", "6b", "6c", "6d", "6e", "6f",
	    "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7a", "7b", "7c", "7d", "7e", "7f",
	    "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8a", "8b", "8c", "8d", "8e", "8f",
	    "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9a", "9b", "9c", "9d", "9e", "9f",
	    "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "aa", "ab", "ac", "ad", "ae", "af",
	    "b0", "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "ba", "bb", "bc", "bd", "be", "bf",
	    "c0", "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "ca", "cb", "cc", "cd", "ce", "cf",
	    "d0", "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "da", "db", "dc", "dd", "de", "df",
	    "e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "ea", "eb", "ec", "ed", "ee", "ef",
	    "f0", "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "fa", "fb", "fc", "fd", "fe", "ff"
	};
	
	public static String byteToHex(byte b){
		return byteToHexTable[b & 0xFF];
	}
	
	public static String byteToHex(byte[] bytes){
		StringBuilder sb = new StringBuilder(bytes.length*2);
		for(byte b : bytes) sb.append(byteToHexTable[b & 0xFF]);
		return sb.toString();
	}
	
	public static String byteToHexLowerCase(byte[] bytes){
		StringBuilder sb = new StringBuilder(bytes.length*2);
		for(byte b : bytes) sb.append(byteToHexTableLowerCase[b & 0xFF]);
		return sb.toString();
	}
	
	public static byte[] hexToByte(String hex){
		char[] chars = hex.toCharArray();
		byte[] bytes = new byte[hex.length()/2];
		for(int i=0; i<chars.length; i=i+2){
			bytes[i/2] = (byte) ((hexToByteTable[chars[i]] << 4) ^ hexToByteTable[chars[i+1]]);
		}
		return bytes;
	}
	
	public static byte[] hexToByteUsingMap(String hex){
		byte[] bytes = new byte[hex.length()/2];
		for(int i=0; i<hex.length(); i=i+2){
			bytes[i/2] = hexToByteMap.get(hex.substring(i, i+2));
		}
		return bytes;
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		for(int i=0; i<10000000; i++){
			byte[] bytes = hexToByte("02003038058020C0100900000000000100000000000716285208280021021200376037691584390603D98021012594000000000030303030303030353030303030303030303030303030355B6CAC3DC16BF8F0004000063031323031370014303230303030303030353131313100073033312E342E30000530343331353543414237334231");
		}
		System.out.println(System.nanoTime()-start);
		
		start = System.nanoTime();
		for(int i=0; i<10000000; i++){
			byte[] bytes = hexToByteUsingMap("02003038058020C0100900000000000100000000000716285208280021021200376037691584390603D98021012594000000000030303030303030353030303030303030303030303030355B6CAC3DC16BF8F0004000063031323031370014303230303030303030353131313100073033312E342E30000530343331353543414237334231");
		}
		System.out.println(System.nanoTime()-start);
	}
	
	
}
