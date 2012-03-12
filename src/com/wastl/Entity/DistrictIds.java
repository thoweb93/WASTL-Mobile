package com.wastl.Entity;

/**
 * Provides the id of every district. The id is used to identify a district 
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 06/03/2012
 * @since 1.2.2
 */
public class DistrictIds 
{
	protected static final Integer ID_LWZ 				  = 1023;
	protected static final Integer ID_BAZ_AMSTETTEN 	  = 1006;
	protected static final Integer ID_BAZ_BADEN 		  = 1007;
	protected static final Integer ID_BAZ_BRUCK_LEITHA    = 1008;
	protected static final Integer ID_BAZ_GÄNSENDORF 	  = 1009;
	protected static final Integer ID_BAZ_GMÜND 		  = 1010;
	protected static final Integer ID_AAZ_KLOSTERNEUBURG  = 1013;
	protected static final Integer ID_AAZ_PURKERSDORF 	  = 1021;
	protected static final Integer ID_AAZ_SCHWECHAT 	  = 1004;
	protected static final Integer ID_BAZ_HOLLABRUNN 	  = 1011;
	protected static final Integer ID_BAZ_HORN 		      = 1012;
	protected static final Integer ID_BAZ_STOCKERAU 	  = 1026;
	protected static final Integer ID_BAZ_KREMS_DONAU 	  = 1000;
	protected static final Integer ID_BAZ_LILIENFELD 	  = 1014;
	protected static final Integer ID_BAZ_MELK 		   	  = 1015;
	protected static final Integer ID_BAZ_MISTELBACH 	  = 1003;
	protected static final Integer ID_BAZ_MÖDLING 		  = 1002;
	protected static final Integer ID_BAZ_NEUNKIRCHEN 	  = 1005;
	protected static final Integer ID_BAZ_ST_PÖLTEN 	  = 1001;
	protected static final Integer ID_BAZ_SCHEIBBS 	   	  = 1016;
	protected static final Integer ID_BAZ_TULLN 		  = 1028;
	protected static final Integer ID_BAZ_WAIDHOFEN_THAYA = 1027;
	protected static final Integer ID_BAZ_WIENER_NEUSTADT = 1019;
	protected static final Integer ID_BAZ_ZWETTL 		  = 1020;
	
	protected static Integer[] fetchAllIds()
	{
		return new Integer[]{ID_AAZ_KLOSTERNEUBURG, ID_AAZ_PURKERSDORF, ID_AAZ_SCHWECHAT, ID_BAZ_AMSTETTEN, ID_BAZ_BADEN, ID_BAZ_BRUCK_LEITHA, 
				ID_BAZ_GMÜND, ID_BAZ_GÄNSENDORF, ID_BAZ_HOLLABRUNN, ID_BAZ_HORN, ID_BAZ_KREMS_DONAU, ID_BAZ_LILIENFELD, ID_BAZ_MELK, ID_BAZ_MISTELBACH,
				ID_BAZ_MÖDLING, ID_BAZ_NEUNKIRCHEN, ID_BAZ_SCHEIBBS, ID_BAZ_ST_PÖLTEN, ID_BAZ_STOCKERAU, ID_BAZ_TULLN, ID_BAZ_WAIDHOFEN_THAYA,
				ID_BAZ_WIENER_NEUSTADT, ID_BAZ_ZWETTL, ID_LWZ};
	}
}
