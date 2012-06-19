/*
 * Filename: EnumFireDepartments.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: provides the IDs,URL-additions,Names to identify the district
 */
package com.wastl.Enums;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class EnumFireDepartments {

	//used to retrieve the fireDepartments in a district
	//URL: http://www.feuerwehr-krems.at/CodePages/Wastl/GetDaten/GetWastlBezirk.asp?<DISTRICT>
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
	
	private final String ID_BAZ_KREMS_DONAU			= "10";
	private final String ID_BAZ_ST_PÖLTEN 			= "17";
	private final String ID_BAZ_MÖDLING				= "14";
	private final String ID_BAZ_MISTELBACH			= "13";
	private final String ID_AAZ_SCHWECHAT			= "063";
	private final String ID_BAZ_NEUNKIRCHEN			= "15";
	private final String ID_BAZ_AMSTETTEN			= "01";
	private final String ID_BAZ_BADEN				= "02";
	private final String ID_BAZ_BRUCK_LEITHA		= "03";
	private final String ID_BAZ_GÄNSENDORF			= "04";
	private final String ID_BAZ_GMÜND				= "05";
	private final String ID_BAZ_HOLLABRUNN			= "07";
	private final String ID_BAZ_HORN				= "08";
	private final String ID_AAZ_KLOSTERNEUBURG		= "061";
	private final String ID_BAZ_LILIENFELD			= "11";
	private final String ID_BAZ_MELK				= "12";
	private final String ID_BAZ_SCHEIBBS			= "18";
	private final String ID_BAZ_WIENER_NEUSTADT		= "21";
	private final String ID_BAZ_ZWETTL				= "22";
	private final String ID_AAZ_PURKERSDORF			= "062";
	private final String ID_BAZ_STOCKERAU			= "09";
	private final String ID_BAZ_WAIDHOFEN			= "20";
	private final String ID_BAZ_TULLN				= "19";
	
	//File names
	private final String FILE_BAZ_KREMS_DONAU		= "wastl_krems.xml";
	private final String FILE_BAZ_ST_PÖLTEN 		= "wastl_st_poelten.xml";
	private final String FILE_BAZ_MÖDLING			= "wastl_mödling.xml";
	private final String FILE_BAZ_MISTELBACH		= "wastl_mistelbach";
	private final String FILE_AAZ_SCHWECHAT			= "wastl_schwechat";
	private final String FILE_BAZ_NEUNKIRCHEN		= "wastl_neunkirchen";
	private final String FILE_BAZ_AMSTETTEN			= "wastl_amstetten";
	private final String FILE_BAZ_BADEN				= "wastl_baden";
	private final String FILE_BAZ_BRUCK_LEITHA		= "wastl_bruck";
	private final String FILE_BAZ_GÄNSENDORF		= "wastl_gaensendorf";
	private final String FILE_BAZ_GMÜND				= "wastl_gmuend";
	private final String FILE_BAZ_HOLLABRUNN		= "wastl_hollabrunn";
	private final String FILE_BAZ_HORN				= "wastl_horn";
	private final String FILE_AAZ_KLOSTERNEUBURG	= "wastl_klosterneuburg";
	private final String FILE_BAZ_LILIENFELD		= "wastl_lilienfeld";
	private final String FILE_BAZ_MELK				= "wastl_melk";
	private final String FILE_BAZ_SCHEIBBS			= "wastl_scheibbs";
	private final String FILE_BAZ_WIENER_NEUSTADT	= "wastl_wiener_neustadt";
	private final String FILE_BAZ_ZWETTL			= "wastl_zwettl";
	private final String FILE_AAZ_PURKERSDORF		= "wastl_purkersdorf";
	private final String FILE_BAZ_STOCKERAU			= "wastl_stockerau";
	private final String FILE_BAZ_WAIDHOFEN			= "wastl_waidhofen";
	private final String FILE_BAZ_TULLN				= "wastl_tulln";
	
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

	public static enum ID_FireDistricts{ 	LWZ, BAZ_AMSTETTEN, BAZ_BADEN, BAZ_BRUCK_LEITHA, 
									BAZ_GÄNSENDORF, BAZ_GMÜND, AAZ_KLOSTERNEUBURG, AAZ_PURKERSDORF, 
									AAZ_SCHWECHAT, BAZ_HOLLABRUNN, BAZ_HORN, BAZ_STOCKERAU,BAZ_KREMS_DONAU,
									BAZ_LILIENFELD, BAZ_MELK, BAZ_MISTELBACH, BAZ_MÖDLING, BAZ_NEUNKIRCHEN, 
									BAZ_ST_PÖLTEN, BAZ_SCHEIBBS, BAZ_TULLN, BAZ_WAIDHOFEN_THAYA,
									BAZ_WIENER_NEUSTADT, BAZ_ZWETTL; }

	//returns a url for a given district
	public String getURL(ID_FireDistricts _district)
	{
		switch(_district)
		{
		case BAZ_AMSTETTEN:
			return this.URL_BAZ_AMSTETTEN;
		case BAZ_BADEN:
			return this.URL_BAZ_BADEN;
		case BAZ_BRUCK_LEITHA:
			return this.URL_BAZ_BRUCK_LEITHA;
		case BAZ_GÄNSENDORF:
			return this.URL_BAZ_GÄNSENDORF;
		case BAZ_GMÜND:
			return this.URL_BAZ_GMÜND;
		case AAZ_KLOSTERNEUBURG:
			return this.URL_AAZ_KLOSTERNEUBURG;
		case AAZ_PURKERSDORF:
			return this.URL_AAZ_PURKERSDORF;
		case AAZ_SCHWECHAT:
			return this.URL_AAZ_SCHWECHAT;
		case BAZ_HOLLABRUNN:
			return this.URL_BAZ_HOLLABRUNN;
		case BAZ_HORN:
			return this.URL_BAZ_HORN;
		case BAZ_STOCKERAU:
			return this.URL_BAZ_STOCKERAU;
		case BAZ_KREMS_DONAU:
			return this.URL_BAZ_KREMS_DONAU;
		case BAZ_LILIENFELD:
			return this.URL_BAZ_LILIENFELD;
		case BAZ_MELK:
			return this.URL_BAZ_MELK;
		case BAZ_MISTELBACH:
			return this.URL_BAZ_MISTELBACH;
		case BAZ_MÖDLING:
			return this.URL_BAZ_MÖDLING;
		case BAZ_NEUNKIRCHEN:
			return this.URL_BAZ_NEUNKIRCHEN;
		case BAZ_ST_PÖLTEN:
			return this.URL_BAZ_ST_PÖLTEN;
		case BAZ_SCHEIBBS:
			return this.URL_BAZ_SCHEIBBS;
		case BAZ_TULLN:
			return this.URL_BAZ_TULLN;
		case BAZ_WAIDHOFEN_THAYA:
			return this.URL_BAZ_WAIDHOFEN;
		case BAZ_WIENER_NEUSTADT:
			return this.URL_BAZ_WIENER_NEUSTADT;
		case BAZ_ZWETTL:
			return this.URL_BAZ_ZWETTL;
		default:
			return this.URL_BAZ_KREMS_DONAU;
		}
	}
	public String getFileName(ID_FireDistricts _district)
	{
		switch(_district)
		{
		case BAZ_AMSTETTEN:
			return this.FILE_BAZ_AMSTETTEN;
		case BAZ_BADEN:
			return this.FILE_BAZ_BADEN;
		case BAZ_BRUCK_LEITHA:
			return this.FILE_BAZ_BRUCK_LEITHA;
		case BAZ_GÄNSENDORF:
			return this.FILE_BAZ_GÄNSENDORF;
		case BAZ_GMÜND:
			return this.FILE_BAZ_GMÜND;
		case AAZ_KLOSTERNEUBURG:
			return this.FILE_AAZ_KLOSTERNEUBURG;
		case AAZ_PURKERSDORF:
			return this.FILE_AAZ_PURKERSDORF;
		case AAZ_SCHWECHAT:
			return this.FILE_AAZ_SCHWECHAT;
		case BAZ_HOLLABRUNN:
			return this.FILE_BAZ_HOLLABRUNN;
		case BAZ_HORN:
			return this.FILE_BAZ_HORN;
		case BAZ_STOCKERAU:
			return this.FILE_BAZ_STOCKERAU;
		case BAZ_KREMS_DONAU:
			return this.FILE_BAZ_KREMS_DONAU;
		case BAZ_LILIENFELD:
			return this.FILE_BAZ_LILIENFELD;
		case BAZ_MELK:
			return this.FILE_BAZ_MELK;
		case BAZ_MISTELBACH:
			return this.FILE_BAZ_MISTELBACH;
		case BAZ_MÖDLING:
			return this.FILE_BAZ_MÖDLING;
		case BAZ_NEUNKIRCHEN:
			return this.FILE_BAZ_NEUNKIRCHEN;
		case BAZ_ST_PÖLTEN:
			return this.FILE_BAZ_ST_PÖLTEN;
		case BAZ_SCHEIBBS:
			return this.FILE_BAZ_SCHEIBBS;
		case BAZ_TULLN:
			return this.FILE_BAZ_TULLN;
		case BAZ_WAIDHOFEN_THAYA:
			return this.FILE_BAZ_WAIDHOFEN;
		case BAZ_WIENER_NEUSTADT:
			return this.FILE_BAZ_WIENER_NEUSTADT;
		case BAZ_ZWETTL:
			return this.FILE_BAZ_ZWETTL;
		default:
			return this.FILE_BAZ_KREMS_DONAU;
		}
	}
	public String getId(ID_FireDistricts _district)
	{
		switch(_district)
		{
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
			return this.ID_BAZ_WAIDHOFEN;
		case BAZ_WIENER_NEUSTADT:
			return this.ID_BAZ_WIENER_NEUSTADT;
		case BAZ_ZWETTL:
			return this.ID_BAZ_ZWETTL;
		default:
			return this.ID_BAZ_KREMS_DONAU;
		}
	}
	public ID_FireDistricts getEnumFromString(String _district)
	{
		if(_district.equals(this.AAZ_KLOSTERNEUBURG))
			return ID_FireDistricts.AAZ_KLOSTERNEUBURG;
		else if(_district.equals(this.AAZ_PURKERSDORF))
			return ID_FireDistricts.AAZ_PURKERSDORF;
		else if(_district.equals(this.AAZ_SCHWECHAT))
			return ID_FireDistricts.AAZ_SCHWECHAT;
		else if(_district.equals(this.BAZ_AMSTETTEN))
			return ID_FireDistricts.BAZ_AMSTETTEN;
		else if(_district.equals(this.BAZ_BADEN))
			return ID_FireDistricts.BAZ_BADEN;
		else if(_district.equals(this.BAZ_BRUCK_LEITHA))
			return ID_FireDistricts.BAZ_BRUCK_LEITHA;
		else if(_district.equals(this.BAZ_GMÜND))
			return ID_FireDistricts.BAZ_GMÜND;
		else if(_district.equals(this.BAZ_GÄNSENDORF))
			return ID_FireDistricts.BAZ_GÄNSENDORF;
		else if(_district.equals(this.BAZ_HOLLABRUNN))
			return ID_FireDistricts.BAZ_HOLLABRUNN;
		else if(_district.equals(this.BAZ_Horn))
			return ID_FireDistricts.BAZ_HORN;
		else if(_district.equals(this.BAZ_KREMS))
			return ID_FireDistricts.BAZ_KREMS_DONAU;
		else if(_district.equals(this.BAZ_LILIENFELD))
			return ID_FireDistricts.BAZ_LILIENFELD;
		else if(_district.equals(this.BAZ_MELK))
			return ID_FireDistricts.BAZ_MELK;
		else if(_district.equals(this.BAZ_MISTELBACH))
			return ID_FireDistricts.BAZ_MISTELBACH;
		else if(_district.equals(this.BAZ_MÖDLING))
			return ID_FireDistricts.BAZ_MÖDLING;
		else if(_district.equals(this.BAZ_NEUNKIRCHEN))
			return ID_FireDistricts.BAZ_NEUNKIRCHEN;
		else if(_district.equals(this.BAZ_SCHEIBBS))
			return ID_FireDistricts.BAZ_SCHEIBBS;
		else if(_district.equals(this.BAZ_ST_PÖLTEN))
			return ID_FireDistricts.BAZ_ST_PÖLTEN;
		else if(_district.equals(this.BAZ_STOCKERAU))
			return ID_FireDistricts.BAZ_STOCKERAU;
		else if(_district.equals(this.BAZ_TULLN))
			return ID_FireDistricts.BAZ_TULLN;
		else if(_district.equals(this.BAZ_WAIDHOFEN_THAYA))
			return ID_FireDistricts.BAZ_WAIDHOFEN_THAYA;
		else if(_district.equals(this.BAZ_WIENER_NEUSTADT))
			return ID_FireDistricts.BAZ_WIENER_NEUSTADT;
		else if(_district.equals(this.BAZ_ZWETTL))
			return ID_FireDistricts.BAZ_ZWETTL;
		
		return null;
	}
}

