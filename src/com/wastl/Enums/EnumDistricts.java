/*
 * Filename: EnumDistricts.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: provides the IDs to identify the district
 */
package com.wastl.Enums;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public final class EnumDistricts {
	
	//IDs
	public final String ID_LWZ 					= "1023";
	public final String ID_BAZ_AMSTETTEN 		= "1006";
	public final String ID_BAZ_BADEN 			= "1007";
	public final String ID_BAZ_BRUCK_LEITHA 	= "1008";
	public final String ID_BAZ_GÄNSENDORF 		= "1009";
	public final String ID_BAZ_GMÜND 			= "1010";
	public final String ID_AAZ_KLOSTERNEUBURG 	= "1013";
	public final String ID_AAZ_PURKERSDORF 		= "1021";
	public final String ID_AAZ_SCHWECHAT 		= "1004";
	public final String ID_BAZ_HOLLABRUNN 		= "1011";
	public final String ID_BAZ_HORN 			= "1012";
	public final String ID_BAZ_STOCKERAU 		= "1026";
	public final String ID_BAZ_KREMS_DONAU 		= "1000";
	public final String ID_BAZ_LILIENFELD 		= "1014";
	public final String ID_BAZ_MELK 			= "1015";
	public final String ID_BAZ_MISTELBACH 		= "1003";
	public final String ID_BAZ_MÖDLING 			= "1002";
	public final String ID_BAZ_NEUNKIRCHEN 		= "1005";
	public final String ID_BAZ_ST_PÖLTEN 		= "1001";
	public final String ID_BAZ_SCHEIBBS 		= "1016";
	public final String ID_BAZ_TULLN 			= "1028";
	public final String ID_BAZ_WAIDHOFEN_THAYA 	= "1027";
	public final String ID_BAZ_WIENER_NEUSTADT 	= "1019";
	public final String ID_BAZ_ZWETTL 			= "1020";
	
	public final static int Id_LWZ 					= 1023;
	public final static int Id_BAZ_AMSTETTEN 		= 1006;
	public final static int Id_BAZ_BADEN 			= 1007;
	public final static int Id_BAZ_BRUCK_LEITHA 	= 1008;
	public final static int Id_BAZ_GÄNSENDORF 		= 1009;
	public final static int Id_BAZ_GMÜND 			= 1010;
	public final static int Id_AAZ_KLOSTERNEUBURG	= 1013;
	public final static int Id_AAZ_PURKERSDORF 		= 1021;
	public final static int Id_AAZ_SCHWECHAT 		= 1004;
	public final static int Id_BAZ_HOLLABRUNN 		= 1011;
	public final static int Id_BAZ_HORN 			= 1012;
	public final static int Id_BAZ_STOCKERAU 		= 1026;
	public final static int Id_BAZ_KREMS_DONAU 		= 1000;
	public final static int Id_BAZ_LILIENFELD 		= 1014;
	public final static int Id_BAZ_MELK 			= 1015;
	public final static int Id_BAZ_MISTELBACH 		= 1003;
	public final static int Id_BAZ_MÖDLING 			= 1002;
	public final static int Id_BAZ_NEUNKIRCHEN 		= 1005;
	public final static int Id_BAZ_ST_PÖLTEN 		= 1001;
	public final static int Id_BAZ_SCHEIBBS 		= 1016;
	public final static int Id_BAZ_TULLN 			= 1028;
	public final static int Id_BAZ_WAIDHOFEN_THAYA 	= 1027;
	public final static int Id_BAZ_WIENER_NEUSTADT 	= 1019;
	public final static int Id_BAZ_ZWETTL 			= 1020;
	
	//Name
	public final String LWZ 					= "LWZ";
	public final String BAZ_AMSTETTEN 			= "BAZ Amstetten";
	public final String BAZ_BADEN 				= "BAZ Baden";
	public final String BAZ_BRUCK_LEITHA 		= "BAZ Bruck an der Leitha";
	public final String BAZ_GÄNSENDORF 			= "BAZ Gänsendorf";
	public final String BAZ_GMÜND				= "BAZ Gmünd";
	public final String AAZ_KLOSTERNEUBURG		= "AAZ Klosterneuburg";
	public final String AAZ_PURKERSDORF			= "AAZ Purkersdorf";
	public final String AAZ_SCHWECHAT			= "AAZ Schwechat";
	public final String BAZ_HOLLABRUNN			= "BAZ Hollabrunn";
	public final String BAZ_Horn				= "BAZ Horn";
	public final String BAZ_STOCKERAU			= "BAZ Stockerau";
	public final String BAZ_KREMS				= "BAZ Krems";
	public final String BAZ_LILIENFELD			= "BAZ Lilienfeld";
	public final String BAZ_MELK				= "BAZ Melk";
	public final String BAZ_MISTELBACH			= "BAZ Mistelbach";
	public final String BAZ_MÖDLING				= "BAZ Mödling";
	public final String BAZ_NEUNKIRCHEN			= "BAZ Neunkirchen";
	public final String BAZ_ST_PÖLTEN			= "BAZ St. Pölten";
	public final String BAZ_SCHEIBBS			= "BAZ Scheibbs";
	public final String BAZ_TULLN				= "BAZ Tulln";
	public final String BAZ_WAIDHOFEN_THAYA		= "BAZ Waidhofen";
	public final String BAZ_WIENER_NEUSTADT	 	= "BAZ Wiener Neustadt";
	public final String BAZ_ZWETTL				= "BAZ Zwettl";
	
	public static enum ID_Districts{ 	LWZ, BAZ_AMSTETTEN, BAZ_BADEN, BAZ_BRUCK_LEITHA, 
									BAZ_GÄNSENDORF, BAZ_GMÜND, AAZ_KLOSTERNEUBURG, AAZ_PURKERSDORF, 
									AAZ_SCHWECHAT, BAZ_HOLLABRUNN, BAZ_HORN, BAZ_STOCKERAU,BAZ_KREMS_DONAU,
									BAZ_LILIENFELD, BAZ_MELK, BAZ_MISTELBACH, BAZ_MÖDLING, BAZ_NEUNKIRCHEN, 
									BAZ_ST_PÖLTEN, BAZ_SCHEIBBS, BAZ_TULLN, BAZ_WAIDHOFEN_THAYA,
									BAZ_WIENER_NEUSTADT, BAZ_ZWETTL; }
	
	public String getID(ID_Districts _bezirk)
	{
		switch(_bezirk)
		{
		case LWZ:
			return this.ID_LWZ;
		case BAZ_AMSTETTEN:
			return this.ID_BAZ_AMSTETTEN;
		case BAZ_BADEN:
			return this.ID_BAZ_BADEN;
		case BAZ_BRUCK_LEITHA:
			return this.ID_BAZ_BRUCK_LEITHA;
		case BAZ_GÄNSENDORF:
			return this.ID_BAZ_GÄNSENDORF;
		case BAZ_GMÜND:
			return this.ID_BAZ_GMÜND;
		case AAZ_KLOSTERNEUBURG:
			return this.ID_AAZ_KLOSTERNEUBURG;
		case AAZ_PURKERSDORF:
			return this.ID_AAZ_PURKERSDORF;
		case AAZ_SCHWECHAT:
			return this.ID_AAZ_SCHWECHAT;
		case BAZ_HOLLABRUNN:
			return this.ID_BAZ_HOLLABRUNN;
		case BAZ_HORN:
			return this.ID_BAZ_HORN;
		case BAZ_STOCKERAU:
			return this.ID_BAZ_STOCKERAU;
		case BAZ_KREMS_DONAU:
			return this.ID_BAZ_KREMS_DONAU;
		case BAZ_LILIENFELD:
			return this.ID_BAZ_LILIENFELD;
		case BAZ_MELK:
			return this.ID_BAZ_MELK;
		case BAZ_MISTELBACH:
			return this.ID_BAZ_MISTELBACH;
		case BAZ_MÖDLING:
			return this.ID_BAZ_MÖDLING;
		case BAZ_NEUNKIRCHEN:
			return this.ID_BAZ_NEUNKIRCHEN;
		case BAZ_ST_PÖLTEN:
			return this.ID_BAZ_ST_PÖLTEN;
		case BAZ_SCHEIBBS:
			return this.ID_BAZ_SCHEIBBS;
		case BAZ_TULLN:
			return this.ID_BAZ_TULLN;
		case BAZ_WAIDHOFEN_THAYA:
			return this.ID_BAZ_WAIDHOFEN_THAYA;
		case BAZ_WIENER_NEUSTADT:
			return this.ID_BAZ_WIENER_NEUSTADT;
		case BAZ_ZWETTL:
			return this.ID_BAZ_ZWETTL;
		default:
			return this.ID_BAZ_KREMS_DONAU;
		}
	}
	public String getDistrict(Integer _bezirk)
	{
		switch(_bezirk)
		{
		case Id_LWZ:
			return this.LWZ;
		case Id_AAZ_KLOSTERNEUBURG:
			return this.AAZ_KLOSTERNEUBURG;
		case Id_AAZ_PURKERSDORF:
			return this.AAZ_PURKERSDORF;
		case Id_AAZ_SCHWECHAT:
			return this.AAZ_SCHWECHAT;
		case Id_BAZ_AMSTETTEN:
			return this.BAZ_AMSTETTEN;
		case Id_BAZ_BADEN:
			return this.BAZ_BADEN;
		case Id_BAZ_BRUCK_LEITHA:
			return this.BAZ_BRUCK_LEITHA;
		case Id_BAZ_GÄNSENDORF:
			return this.BAZ_GÄNSENDORF;
		case Id_BAZ_GMÜND:
			return this.BAZ_GMÜND;
		case Id_BAZ_HOLLABRUNN:
			return this.BAZ_HOLLABRUNN;
		case Id_BAZ_HORN:
			return this.BAZ_Horn;
		case Id_BAZ_KREMS_DONAU:
			return this.BAZ_KREMS;
		case Id_BAZ_LILIENFELD:
			return this.BAZ_LILIENFELD;
		case Id_BAZ_MELK:
			return this.BAZ_MELK;
		case Id_BAZ_MISTELBACH:
			return this.BAZ_MISTELBACH;
		case Id_BAZ_MÖDLING:
			return this.BAZ_MÖDLING;
		case Id_BAZ_NEUNKIRCHEN:
			return this.BAZ_NEUNKIRCHEN;
		case Id_BAZ_ST_PÖLTEN:
			return this.BAZ_ST_PÖLTEN;
		case Id_BAZ_SCHEIBBS:
			return this.BAZ_SCHEIBBS;
		case Id_BAZ_STOCKERAU:
			return this.BAZ_STOCKERAU;
		case Id_BAZ_TULLN:
			return this.BAZ_TULLN;
		case Id_BAZ_WAIDHOFEN_THAYA:
			return this.BAZ_WAIDHOFEN_THAYA;
		case Id_BAZ_WIENER_NEUSTADT:
			return this.BAZ_WIENER_NEUSTADT;
		case Id_BAZ_ZWETTL:
			return this.BAZ_ZWETTL;
		default:
			return this.BAZ_KREMS;
		}
	}
	
}
