package grammar_gxml;

import java_cup.runtime.*;
      
%%

%public
%line
%column
%cup
%ignorecase             //Ignorar mayúsculas y minúsculas.
   
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
    Comment = {TraditionalComment} | {EndOfLineComment}

    TraditionalComment   = "#$" [^$] ~"$#" | "#$" "$"+ "#"
    // Comment can be the last line of the file, without line terminator.
    EndOfLineComment     = "##" {InputCharacter}* {LineTerminator}?


    Identifier = ([:jletter:] | "_") ([:jletterdigit:] | "_")*

    Number = [0-9]+(\.[0-9]+)?

    Hex = "#"([0-9a-fA-F]{6})

    SChar = [^\"\\\n\r] | {EscChar}
    EscChar = \\[ntbrf\\\'\"]

    Contenido = [^("#"+)<\r\n]+

%state STRING
%state TAG
%state F_CALL

%%

<YYINITIAL>{
        "<"                                         { yybegin(TAG); return symbol(sym.OPENTAG); }

        {Comment}                                   { /* ignore */ }
        {WhiteSpace}+                               { /* ignore */ }

        {Contenido}                                 { return symbol(sym.CONTENIDO, yytext()); }

        
    }

<TAG>{
        ">"                                         { yybegin(YYINITIAL); return symbol(sym.CLOSETAG); }
        "/"                                         { return symbol(sym.SLASH); }

        "importar"                                  { return symbol(sym.IMPORTAR); }
        "ventana"                                   { return symbol(sym.VENTANA); }
        "contenedor"                                { return symbol(sym.CONTENEDOR); }
        "texto"                                     { return symbol(sym.TEXTO); }
        "control"                                   { return symbol(sym.CONTROL); }
        "listadatos"                                { return symbol(sym.LISTADATOS); }
        "dato"                                      { return symbol(sym.DATO); }
        "defecto"                                   { return symbol(sym.DEFECTO); }
        "multimedia"                                { return symbol(sym.MULTIMEDIA); }
        "boton"                                     { return symbol(sym.BOTON); }
        "enviar"                                    { return symbol(sym.ENVIAR); }

        "id"                                        { return symbol(sym.ID); }
        "tipo"                                      { return symbol(sym.TIPO); }
        "color"                                     { return symbol(sym.COLOR); }
        "AccionInicial"                             { return symbol(sym.ACCIONINICIAL); }
        "AccionFinal"                               { return symbol(sym.ACCIONFINAL); }
        "x"                                         { return symbol(sym.X); }
        "y"                                         { return symbol(sym.Y); }
        "alto"                                      { return symbol(sym.ALTO); }
        "ancho"                                     { return symbol(sym.ANCHO); }
        "borde"                                     { return symbol(sym.BORDE); }
        "nombre"                                    { return symbol(sym.NOMBRE); }
        "fuente"                                    { return symbol(sym.FUENTE); }
        "tam"                                       { return symbol(sym.TAM); }
        "negrita"                                   { return symbol(sym.NEGRITA); }
        "cursiva"                                   { return symbol(sym.CURSIVA); }
        "maximo"                                    { return symbol(sym.MAXIMO); }
        "minimo"                                    { return symbol(sym.MINIMO); }
        "path"                                      { return symbol(sym.PATH); }
        "auto-reproduccion"                         { return symbol(sym.AUTO_REPRODUCCION); }
        "referencia"                                { return symbol(sym.REFERENCIA); }
        "accion"                                    { return symbol(sym.ACCION); }

        "numerico"                                  { return symbol(sym.NUMERICO); }
        "textoarea"                                 { return symbol(sym.TEXTOAREA); }
        "desplegable"                               { return symbol(sym.DESPLEGABLE); }

        "musica"                                    { return symbol(sym.MUSICA); }
        "video"                                     { return symbol(sym.VIDEO); }
        "imagen"                                    { return symbol(sym.IMAGEN); }

        "principal"                                 { return symbol(sym.PRINCIPAL); }
        "secundaria"                                { return symbol(sym.SECUNDARIA); }
        "verdadero"                                 { return symbol(sym.VERDADERO); }
        "falso"                                     { return symbol(sym.FALSO); }

        \"                                          { return symbol(sym.DQ); }
        "="                                         { return symbol(sym.EQ); }
        "{"                                         { yybegin(F_CALL); return symbol(sym.LCURL); }

        {Number}                                    { return symbol(sym.NUM, yytext()); }
        \"{Hex}\"                                   { return symbol(sym.HEX, yytext()); }
        \"{SChar}*\"                                { return symbol(sym.STRINGLIT, yytext()); }

        {WhiteSpace}                                { /* ignore */ }
    }

<F_CALL>{
    /* identifiers */ 
        "nulo"                                      { return symbol(sym.NULO); }
        "verdadero"                                 { return symbol(sym.VERDADERO); }
        "falso"                                     { return symbol(sym.FALSO); }
        {Identifier}                                { return symbol(sym.ID_L, yytext()); }

        /* literals */
        {Number}                                    { return symbol(sym.NUM, yytext()); }
        \"                                          { string.setLength(0); yybegin(STRING); }

        /* group signs */
        
        "}"                                         { yybegin(TAG); return symbol(sym.RCURL); }
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

        ","                                         { return symbol(sym.COMMA); }
        "."                                         { return symbol(sym.DOT); }
        "?"                                         { return symbol(sym.Q); }

        {WhiteSpace}                                { /* ignore */ }
    }

<STRING> {
        \"                             { yybegin(F_CALL); 
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
