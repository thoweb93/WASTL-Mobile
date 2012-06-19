package com.wastl.Entity;

/**
 * Provides the id of every district. The id is used to identify a district 
 * 
 * @author Lukas Bernreiter
 * @version 1.3, 19/06/2012
 * @since 1.2.2
 */
public class DistrictIds 
{
	private static final Integer ID_LWZ 			  	= 1023;
	private static final Integer ID_BAZ_AMSTETTEN 	  	= 1006;
	private static final Integer ID_BAZ_BADEN 		  	= 1007;
	private static final Integer ID_BAZ_BRUCK_LEITHA  	= 1008;
	private static final Integer ID_BAZ_GÄNSENDORF 	  	= 1009;
	private static final Integer ID_BAZ_GMÜND 		   	= 1010;
	private static final Integer ID_AAZ_KLOSTERNEUBURG  = 1013;
	private static final Integer ID_AAZ_PURKERSDORF 	= 1021;
	private static final Integer ID_AAZ_SCHWECHAT 	  	= 1004;
	private static final Integer ID_BAZ_HOLLABRUNN 	  	= 1011;
	private static final Integer ID_BAZ_HORN 		    = 1012;
	private static final Integer ID_BAZ_STOCKERAU 	  	= 1026;
	private static final Integer ID_BAZ_KREMS_DONAU 	= 1000;
	private static final Integer ID_BAZ_LILIENFELD 	  	= 1014;
	private static final Integer ID_BAZ_MELK 		   	= 1015;
	private static final Integer ID_BAZ_MISTELBACH 	  	= 1003;
	private static final Integer ID_BAZ_MÖDLING 		= 1002;
	private static final Integer ID_BAZ_NEUNKIRCHEN 	= 1005;
	private static final Integer ID_BAZ_ST_PÖLTEN 	  	= 1001;
	private static final Integer ID_BAZ_SCHEIBBS 	   	= 1016;
	private static final Integer ID_BAZ_TULLN 		    = 1028;
	private static final Integer ID_BAZ_WAIDHOFEN_THAYA = 1027;
	private static final Integer ID_BAZ_WIENER_NEUSTADT = 1019;
	private static final Integer ID_BAZ_ZWETTL 		    = 1020;
	
	protected static Integer[] fetchAllIds()
	{
		return new Integer[]{ID_AAZ_KLOSTERNEUBURG, ID_AAZ_PURKERSDORF, ID_AAZ_SCHWECHAT, ID_BAZ_AMSTETTEN, ID_BAZ_BADEN, ID_BAZ_BRUCK_LEITHA, 
				ID_BAZ_GMÜND, ID_BAZ_GÄNSENDORF, ID_BAZ_HOLLABRUNN, ID_BAZ_HORN, ID_BAZ_KREMS_DONAU, ID_BAZ_LILIENFELD, ID_BAZ_MELK, ID_BAZ_MISTELBACH,
				ID_BAZ_MÖDLING, ID_BAZ_NEUNKIRCHEN, ID_BAZ_SCHEIBBS, ID_BAZ_ST_PÖLTEN, ID_BAZ_STOCKERAU, ID_BAZ_TULLN, ID_BAZ_WAIDHOFEN_THAYA,
				ID_BAZ_WIENER_NEUSTADT, ID_BAZ_ZWETTL, ID_LWZ};
	}
	
	/* These strings are used to download details about a specific district.  
	 * URL: http://www.feuerwehr-krems.at/CodePages/Wastl/GetDaten/GetWastlBezirk.asp?<DISTRICT> */
	private final String URL_BAZ_KREMS_DONAU		= "?Bezirk=10";
	private final String URL_BAZ_ST_PÖLTEN 			= "?Bezirk=17";
	private final String URL_BAZ_MÖDLING			= "?Bezirk=14";
	private final String URL_BAZ_MISTELBACH			= "?Bezirk=13";
	private final String URL_AAZ_SCHWECHAT			= "?Bezirk=063";
	private final String URL_BAZ_NEUNKIRCHEN		= "?Bezirk=15";
	private final String URL_BAZ_AMSTETTEN			= "?Bezirk=01";
	private final String URL_BAZ_BADEN				= "?Bezirk=02";
	private final String URL_BAZ_BRUCK_LEITHA		= "?Bezirk=03";
	private final String URL_BAZ_GÄNSENDORF			= "?Bezirk=04";
	private final String URL_BAZ_GMÜND				= "?Bezirk=05";
	private final String URL_BAZ_HOLLABRUNN			= "?Bezirk=07";
	private final String URL_BAZ_HORN				= "?Bezirk=08";
	private final String URL_AAZ_KLOSTERNEUBURG		= "?Bezirk=061";
	private final String URL_BAZ_LILIENFELD			= "?Bezirk=11";
	private final String URL_BAZ_MELK				= "?Bezirk=12";
	private final String URL_BAZ_SCHEIBBS			= "?Bezirk=18";
	private final String URL_BAZ_WIENER_NEUSTADT	= "?Bezirk=21";
	private final String URL_BAZ_ZWETTL				= "?Bezirk=22";
	private final String URL_AAZ_PURKERSDORF		= "?Bezirk=062";
	private final String URL_BAZ_STOCKERAU			= "?Bezirk=09";
	private final String URL_BAZ_WAIDHOFEN			= "?Bezirk=20";
	private final String URL_BAZ_TULLN				= "?Bezirk=19";
	
	protected String getURL(Integer _districtId)
	{
		switch(_districtId)
		{
		case 1006:
			return this.URL_BAZ_AMSTETTEN;
		case 1007:
			return this.URL_BAZ_BADEN;
		case 1008:
			return this.URL_BAZ_BRUCK_LEITHA;
		case 1009:
			return this.URL_BAZ_GÄNSENDORF;
		case 1010:
			return this.URL_BAZ_GMÜND;
		case 1013:
			return this.URL_AAZ_KLOSTERNEUBURG;
		case 1021:
			return this.URL_AAZ_PURKERSDORF;
		case 1004:
			return this.URL_AAZ_SCHWECHAT;
		case 1011:
			return this.URL_BAZ_HOLLABRUNN;
		case 1012:
			return this.URL_BAZ_HORN;
		case 1026:
			return this.URL_BAZ_STOCKERAU;
		case 1000:
			return this.URL_BAZ_KREMS_DONAU;
		case 1014:
			return this.URL_BAZ_LILIENFELD;
		case 1015:
			return this.URL_BAZ_MELK;
		case 1003:
			return this.URL_BAZ_MISTELBACH;
		case 1002:
			return this.URL_BAZ_MÖDLING;
		case 1005:
			return this.URL_BAZ_NEUNKIRCHEN;
		case 1001:
			return this.URL_BAZ_ST_PÖLTEN;
		case 1016:
			return this.URL_BAZ_SCHEIBBS;
		case 1028:
			return this.URL_BAZ_TULLN;
		case 1027:
			return this.URL_BAZ_WAIDHOFEN;
		case 1019:
			return this.URL_BAZ_WIENER_NEUSTADT;
		case 1020:
			return this.URL_BAZ_ZWETTL;
		default:
			return this.URL_BAZ_KREMS_DONAU;
		}
	}
}
