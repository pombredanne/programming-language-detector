package org.pescuma.programminglanguagedetector;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FilenameToLanguage {
	
	// Copied from cloc.pl : Copyright (C) 2006-2013 Northrop Grumman Corporation
	
	private static final Map<String, String> extensions = new HashMap<String, String>();
	static {
		extensions.put("abap", "ABAP");
		extensions.put("as", "ActionScript");
		extensions.put("ada", "Ada");
		extensions.put("adb", "Ada");
		extensions.put("ads", "Ada");
		extensions.put("pad", "Ada");
		extensions.put("adso", "ADSO/IDSM");
		extensions.put("ample", "AMPLE");
		extensions.put("dofile", "AMPLE");
		extensions.put("startup", "AMPLE");
		extensions.put("build.xml", "Ant");
		extensions.put("trigger", "Apex Trigger");
		extensions.put("ino", "Arduino Sketch");
		extensions.put("pde", "Arduino Sketch");
		extensions.put("asa", "ASP");
		extensions.put("asp", "ASP");
		extensions.put("asax", "ASP.Net");
		extensions.put("ascx", "ASP.Net");
		extensions.put("asmx", "ASP.Net");
		extensions.put("aspx", "ASP.Net");
		extensions.put("config", "ASP.Net");
		extensions.put("master", "ASP.Net");
		extensions.put("resx", "ASP.Net");
		extensions.put("sitemap", "ASP.Net");
		extensions.put("webinfo", "ASP.Net");
		extensions.put("asm", "Assembly");
		extensions.put("s", "Assembly");
		extensions.put("S", "Assembly");
		extensions.put("ahk", "AutoHotkey");
		extensions.put("awk", "awk");
		extensions.put("bash", "Bourne Again Shell");
		extensions.put("sh", "Bourne Shell");
		extensions.put("c", "C");
		extensions.put("ec", "C");
		extensions.put("pgc", "C");
		extensions.put("csh", "C Shell");
		extensions.put("tcsh", "C Shell");
		extensions.put("cs", "C#");
		extensions.put("C", "C++");
		extensions.put("cc", "C++");
		extensions.put("cpp", "C++");
		extensions.put("cxx", "C++");
		extensions.put("pcc", "C++");
		extensions.put("vcproj", "C++");
		extensions.put("vcxproj", "C++");
		extensions.put("h", "C/C++ Header");
		extensions.put("hh", "C/C++ Header");
		extensions.put("hpp", "C/C++ Header");
		extensions.put("ccs", "CCS");
		extensions.put("clj", "Clojure");
		extensions.put("cljs", "ClojureScript");
		extensions.put("cmake", "CMake");
		extensions.put("cbl", "COBOL");
		extensions.put("CBL", "COBOL");
		extensions.put("cob", "COBOL");
		extensions.put("coffee", "CoffeeScript");
		extensions.put("cfm", "ColdFusion");
		extensions.put("cfc", "ColdFusion CFScript");
		extensions.put("css", "CSS");
		extensions.put("pyx", "Cython");
		extensions.put("d", "D");
		extensions.put("da", "DAL");
		extensions.put("dart", "Dart");
		extensions.put("bat", "DOS Batch");
		extensions.put("dtd", "DTD");
		extensions.put("erl", "Erlang");
		extensions.put("hrl", "Erlang");
		extensions.put("exp", "Expect");
		extensions.put("fs", "F#");
		extensions.put("fsproj", "F#");
		extensions.put("focexec", "Focus");
		extensions.put("f", "Fortran 77");
		extensions.put("f77", "Fortran 77");
		extensions.put("pfo", "Fortran 77");
		extensions.put("f90", "Fortran 90");
		extensions.put("f95", "Fortran 95");
		extensions.put("go", "Go");
		extensions.put("gant", "Groovy");
		extensions.put("groovy", "Groovy");
		extensions.put("hs", "Haskell");
		extensions.put("lhs", "Haskell");
		extensions.put("htm", "HTML");
		extensions.put("html", "HTML");
		extensions.put("xhtml", "HTML");
		extensions.put("idl", "IDL");
		extensions.put("pro", "IDL");
		extensions.put("ism", "InstallShield");
		extensions.put("java", "Java");
		extensions.put("js", "Javascript");
		extensions.put("jsf", "JavaServer Faces");
		extensions.put("jcl", "JCL");
		extensions.put("jsp", "JSP");
		extensions.put("ksc", "Kermit");
		extensions.put("ksh", "Korn Shell");
		extensions.put("less", "LESS");
		extensions.put("l", "lex");
		extensions.put("el", "Lisp");
		extensions.put("jl", "Lisp");
		extensions.put("lisp", "Lisp");
		extensions.put("lsp", "Lisp");
		extensions.put("sc", "Lisp");
		extensions.put("scm", "Lisp");
		extensions.put("cl", "Lisp or OpenCL");
		extensions.put("oscript", "LiveLink OScript");
		extensions.put("lua", "Lua");
		extensions.put("ac", "m4");
		extensions.put("m4", "m4");
		extensions.put("am", "make");
		extensions.put("gnumakefile", "make");
		extensions.put("makefile", "make");
		extensions.put("Makefile", "make");
		extensions.put("m", "MATLAB or Objective C or MUMPS");
		extensions.put("pom", "Maven");
		extensions.put("pom.xml", "Maven");
		extensions.put("i3", "Modula3");
		extensions.put("ig", "Modula3");
		extensions.put("m3", "Modula3");
		extensions.put("mg", "Modula3");
		extensions.put("csproj", "MSBuild scripts");
		extensions.put("vbproj", "MSBuild scripts");
		extensions.put("wdproj", "MSBuild scripts");
		extensions.put("mps", "MUMPS");
		extensions.put("mxml", "MXML");
		extensions.put("build", "NAnt scripts");
		extensions.put("dmap", "NASTRAN DMAP");
		extensions.put("mm", "Objective C++");
		extensions.put("ml", "OCaml or ML");
		extensions.put("mli", "OCaml or ML");
		extensions.put("mll", "OCaml");
		extensions.put("mly", "OCaml");
		extensions.put("glsl", "OpenGL Shading Language");
		extensions.put("fmt", "Oracle Forms");
		extensions.put("rex", "Oracle Reports");
		extensions.put("dpr", "Pascal");
		extensions.put("p", "Pascal");
		extensions.put("pas", "Pascal");
		extensions.put("pp", "Pascal");
		extensions.put("pcl", "Patran Command Language");
		extensions.put("ses", "Patran Command Language");
		extensions.put("perl", "Perl");
		extensions.put("pl", "Perl");
		extensions.put("PL", "Perl");
		extensions.put("plh", "Perl");
		extensions.put("plx", "Perl");
		extensions.put("pm", "Perl");
		extensions.put("php", "PHP");
		extensions.put("php3", "PHP");
		extensions.put("php4", "PHP");
		extensions.put("php5", "PHP");
		extensions.put("inc", "PHP or Pascal");
		extensions.put("pig", "Pig Latin");
		extensions.put("ps1", "PowerShell");
		extensions.put("py", "Python");
		extensions.put("qml", "QML");
		extensions.put("cshtml", "Razor");
		extensions.put("rexx", "Rexx");
		extensions.put("rb", "Ruby");
		extensions.put("rhtml", "Ruby HTML");
		extensions.put("rs", "Rust");
		extensions.put("sass", "SASS");
		extensions.put("scss", "SASS");
		extensions.put("scala", "Scala");
		extensions.put("sed", "sed");
		extensions.put("il", "SKILL");
		extensions.put("ils", "SKILL++");
		extensions.put("smarty", "Smarty");
		extensions.put("tpl", "Smarty");
		extensions.put("sbl", "Softbridge Basic");
		extensions.put("SBL", "Softbridge Basic");
		extensions.put("psql", "SQL");
		extensions.put("sql", "SQL");
		extensions.put("data.sql", "SQL Data");
		extensions.put("spc.sql", "SQL Stored Procedure");
		extensions.put("spoc.sql", "SQL Stored Procedure");
		extensions.put("sproc.sql", "SQL Stored Procedure");
		extensions.put("udf.sql", "SQL Stored Procedure");
		extensions.put("itk", "Tcl/Tk");
		extensions.put("tcl", "Tcl/Tk");
		extensions.put("tk", "Tcl/Tk");
		extensions.put("def", "Teamcenter def");
		extensions.put("met", "Teamcenter met");
		extensions.put("mth", "Teamcenter mth");
		extensions.put("tex", "Tex");
		extensions.put("md", "Text");
		extensions.put("txt", "Text");
		extensions.put("vala", "Vala");
		extensions.put("vapi", "Vala Header");
		extensions.put("sv", "Verilog-SystemVerilog");
		extensions.put("svh", "Verilog-SystemVerilog");
		extensions.put("v", "Verilog-SystemVerilog");
		extensions.put("vhd", "VHDL");
		extensions.put("vhdl", "VHDL");
		extensions.put("vim", "vim script");
		extensions.put("bas", "Visual Basic");
		extensions.put("cls", "Visual Basic");
		extensions.put("ctl", "Visual Basic");
		extensions.put("dsr", "Visual Basic");
		extensions.put("frm", "Visual Basic");
		extensions.put("vb", "Visual Basic");
		extensions.put("vba", "Visual Basic");
		extensions.put("vbp", "Visual Basic");
		extensions.put("vbs", "Visual Basic");
		extensions.put("vbw", "Visual Basic");
		extensions.put("component", "Visualforce Component");
		extensions.put("page", "Visualforce Page");
		extensions.put("xaml", "XAML");
		extensions.put("xml", "XML");
		extensions.put("xsd", "XSD");
		extensions.put("xsl", "XSLT");
		extensions.put("xslt", "XSLT");
		extensions.put("y", "yacc");
		extensions.put("yaml", "YAML");
		extensions.put("yml", "YAML");
	};
	
	private static final Map<String, String> binaryExtensions = new HashMap<String, String>();
	static {
		binaryExtensions.put("jar", "Java");
	};
	
	private static final Map<String, String> filenames = new HashMap<String, String>();
	static {
		filenames.put("build.xml", "Ant");
		filenames.put("cmakelists.txt", "CMake");
		filenames.put("gnumakefile", "make");
		filenames.put("makefile", "make");
		filenames.put("pom.xml", "Maven");
	};
	
	public static String detectLanguage(String filename) {
		return detectLanguage(filename, false);
	}
	
	public static String detectLanguage(String filename, boolean includeBinaries) {
		if (filename == null)
			return null;
		
		String result = filenames.get(getName(filename).toLowerCase(Locale.ENGLISH));
		if (result != null)
			return result;
		
		String doubleExtension = getDoubleExtension(filename).toLowerCase(Locale.ENGLISH);
		result = extensions.get(doubleExtension);
		if (result != null)
			return result;
		
		String extension = getExtension(filename).toLowerCase(Locale.ENGLISH);
		result = extensions.get(extension);
		if (result != null)
			return result;
		
		if (includeBinaries) {
			result = binaryExtensions.get(doubleExtension);
			if (result != null)
				return result;
			
			result = binaryExtensions.get(extension);
			if (result != null)
				return result;
		}
		
		return null;
	}
	
	private static String getName(String filename) {
		return new File(filename).getName();
	}
	
	private static String getExtension(String filename) {
		int pos = filename.lastIndexOf('.');
		if (pos < 0)
			return "";
		
		return filename.substring(pos + 1);
	}
	
	private static String getDoubleExtension(String filename) {
		int pos = filename.lastIndexOf('.');
		if (pos < 0)
			return "";
		
		pos = filename.lastIndexOf('.', pos - 1);
		if (pos < 0)
			return "";
		
		return filename.substring(pos + 1);
	}
	
	public static boolean isKnownFileType(String filename) {
		return isKnownFileType(filename, false);
	}
	
	public static boolean isKnownFileType(String filename, boolean includeBinaries) {
		return detectLanguage(filename, includeBinaries) != null;
	}
}
