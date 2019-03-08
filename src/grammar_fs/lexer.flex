package grammar_fs;

import java_cup.runtime.*;
      
%%

%line
%column
%cup
   
%{   
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

    LineTerminator = \r|\n|\r\n
    InputCharacter = [^\r\n]
    WhiteSpace     = {LineTerminator} | [ \t\f]

    /* comments */
    Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

    TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
    // Comment can be the last line of the file, without line terminator.
    EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
    DocumentationComment = "/**" {CommentContent} "*"+ "/"
    CommentContent       = ( [^*] | \*+ [^/*] )*

    Identifier = ([:jletter:] | "_") ([:jletterdigit:] | "_")*

    Number = [0-9]+(\.[0-9]+)?

%state STRING

%%

    /* keywords */
    <YYINITIAL> "nulo"                              { return symbol(sym.NULO); }
    <YYINITIAL> "Verdadero"                         { return symbol(sym.VERDADERO); }
    <YYINITIAL> "Falso"                             { return symbol(sym.FALSO); }
    <YYINITIAL> "var"                               { return symbol(sym.VAR); }
    <YYINITIAL> "imprimir"                          { return symbol(sym.IMPRIMIR); }
    <YYINITIAL> "importar"                          { return symbol(sym.IMPORTAR); }
    <YYINITIAL> "detener"                           { return symbol(sym.DETENER); }
    <YYINITIAL> "selecciona"                        { return symbol(sym.SELECCIONA); }
    <YYINITIAL> "caso"                              { return symbol(sym.CASO); }
    <YYINITIAL> "defecto"                           { return symbol(sym.DEFECTO); }
    <YYINITIAL> "retornar"                          { return symbol(sym.RETORNAR); }
    <YYINITIAL> "si"                                { return symbol(sym.SI); }
    <YYINITIAL> "sino"                              { return symbol(sym.SINO); }
    <YYINITIAL> "funcion"                           { return symbol(sym.FUNCION); }
    <YYINITIAL> "descendente"                       { return symbol(sym.DESCENDENTE); }
    <YYINITIAL> "ascendente"                        { return symbol(sym.ASCENDENTE); }
    <YYINITIAL> "crearArrayDesdeArchivo"            { return symbol(sym.CADA); }
    <YYINITIAL> "invertir"                          { return symbol(sym.INVERTIR); }
    <YYINITIAL> "maximo"                            { return symbol(sym.MAXIMO); }
    <YYINITIAL> "minimo"                            { return symbol(sym.MINIMO); }
    <YYINITIAL> "filtrar"                           { return symbol(sym.FILTRAR); }
    <YYINITIAL> "buscar"                            { return symbol(sym.BUSCAR); }
    <YYINITIAL> "map"                               { return symbol(sym.MAP); }
    <YYINITIAL> "reduce"                            { return symbol(sym.REDUCE); }
    <YYINITIAL> "todos"                             { return symbol(sym.TODOS); }
    <YYINITIAL> "alguno"                            { return symbol(sym.ALGUNO); }
    <YYINITIAL> "LeerGxml"                          { return symbol(sym.LEERGXML); }
    <YYINITIAL> "ObtenerPorEtiqueta"                { return symbol(sym.OPE); }
    <YYINITIAL> "ObtenerPorId"                      { return symbol(sym.OPI); }
    <YYINITIAL> "ObtenerPorNombre"                  { return symbol(sym.OPN); }
    <YYINITIAL> "CrearVentana"                      { return symbol(sym.CREARVENTANA); }
    <YYINITIAL> "CrearContenedor"                   { return symbol(sym.CREARCONTENEDOR); }
    <YYINITIAL> "CrearTexto"                        { return symbol(sym.CREARTEXTO); }
    <YYINITIAL> "CrearCajaTexto"                    { return symbol(sym.CREARCAJA); }
    <YYINITIAL> "CrearAreaTexto"                    { return symbol(sym.CREARAREA); }
    <YYINITIAL> "CrearControlNumerico"              { return symbol(sym.CREARNUMERICO); }
    <YYINITIAL> "CrearDesplegable"                  { return symbol(sym.CREARDESPLEGABLE); }
    <YYINITIAL> "CrearBoton"                        { return symbol(sym.CREARBOTON); }
    <YYINITIAL> "CrearImagen"                       { return symbol(sym.CREARIMAGEN); }
    <YYINITIAL> "CrearReproductor"                  { return symbol(sym.CREARREPRODUCTOR); }
    <YYINITIAL> "CrearVideo"                        { return symbol(sym.CREARVIDEO); }
    <YYINITIAL> "AlClic"                            { return symbol(sym.ALCLIC); }
    <YYINITIAL> "AlCargar"                          { return symbol(sym.ALCARGAR); }
    <YYINITIAL> "AlCerrar"                          { return symbol(sym.ALCERRAR); }

    <YYINITIAL> {
        /* identifiers */ 
        {Identifier}                                { return symbol(sym.ID, yytext()); }

        /* literals */
        {Number}                                    { return symbol(sym.NUM, yytext()); }
        \"                                          { string.setLength(0); yybegin(STRING); }

        /* group signs */
        "{"                                         { return symbol(sym.LCURL); }
        "}"                                         { return symbol(sym.RCURL); }
        "("                                         { return symbol(sym.LPAR); }
        ")"                                         { return symbol(sym.RPAR); }
        "["                                         { return symbol(sym.LBRACK); }
        "]"                                         { return symbol(sym.RBRACK); }

        /* operators */
        "++"                                        { return symbol(sym.PLUSPLUS); }
        "--"                                        { return symbol(sym.MINUSMINUS); }
        "+="                                        { return symbol(sym.PLUSEQ); }
        "-="                                        { return symbol(sym.MINUSEQ); }
        "*="                                        { return symbol(sym.TIMESEQ); }
        "/="                                        { return symbol(sym.DIVEQ); }
        
        "+"                                         { return symbol(sym.PLUS); }
        "-"                                         { return symbol(sym.MINUS); }
        "*"                                         { return symbol(sym.TIMES); }
        "/"                                         { return symbol(sym.DIV); }
        "^"                                         { return symbol(sym.POW); }

        ">="                                        { return symbol(sym.MORETHANEQ); }
        "<="                                        { return symbol(sym.LESSTHANEQ); }
        "=="                                        { return symbol(sym.EQEQ); }
        "!="                                        { return symbol(sym.NOTEQ); }
        ">"                                         { return symbol(sym.MORETHAN); }
        "<"                                         { return symbol(sym.LESSTHAN); }

        "&&"                                        { return symbol(sym.AND); }
        "||"                                        { return symbol(sym.OR); }
        "!"                                         { return symbol(sym.NOT); }

        "="                                         { return symbol(sym.EQ); }

        /* punctuation */
        ":"                                         { return symbol(sym.COLON); }
        ";"                                         { return symbol(sym.SEMI); }
        ","                                         { return symbol(sym.COMMA); }
        "."                                         { return symbol(sym.DOT); }
        "?"                                         { return symbol(sym.Q); }

        /* comments */
        {Comment}                      { /* ignore */ }

        /* whitespace */
        {WhiteSpace}                   { /* ignore */ }
    }

    <STRING> {
        \"                             { yybegin(YYINITIAL); 
                                         return symbol(sym.STRING, 
                                         string.toString()); }
        [^\n\r\"\\]+                   { string.append( yytext() ); }
        \\t                            { string.append('\t'); }
        \\n                            { string.append('\n'); }

        \\r                            { string.append('\r'); }
        \\\"                           { string.append('\"'); }
        \\                             { string.append('\\'); }
    }

    /* error fallback */
    [^]                              { throw new Error("Illegal character <"+
                                                        yytext()+">"); }
