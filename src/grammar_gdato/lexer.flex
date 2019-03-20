package grammar_gdato;

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


%state STRING
%state TAG

%%

<YYINITIAL>{
        "<"                                         { yybegin(TAG); return symbol(sym.OPENTAG); }

        {Number}                                    { return symbol(sym.NUM, yytext()); }
        "verdadero"                                 { return symbol(sym.VERDADERO); }
        "falso"                                     { return symbol(sym.FALSO); }
        "nulo"                                      { return symbol(sym.NULO); }
        \"                                          { string.setLength(0); yybegin(STRING); }

        {WhiteSpace}                                { /* ignore */ }        
    }

<TAG>{
        ">"                                         { yybegin(YYINITIAL); return symbol(sym.CLOSETAG); }
        "/"                                         { return symbol(sym.SLASH); }

        "lista"                                     { return symbol(sym.LISTA); }
        "principal"                                 { return symbol(sym.PRINCIPAL); }

        {Identifier}                                { return symbol(sym.ID, yytext()); }
        
        {WhiteSpace}                                { /* ignore */ }
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
