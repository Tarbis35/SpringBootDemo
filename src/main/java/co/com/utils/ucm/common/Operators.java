package co.com.utils.ucm.common;

public abstract interface Operators {
    public static abstract interface UCM_COMUN_SYMBOLS {
        public static final String COMILLA = "`";
        public static final String ABRE_PARENTESIS = "(";
        public static final String CIERRA_PARENTESIS = ")";
    }

    public static abstract interface UCM_LOGIC_OPERATORS {
        public static final String Y = "<AND>";
        public static final String O = "<OR>";
        public static final String NO = "<NOT>";
    }

    public static abstract interface UCM_DATE_OPERATORS {
        public static final String EL_O_DESPUES_DE = ">=";
        public static final String ANTES_DE = "<";
    }

    public static abstract interface UCM_STRING_OPERATORS {
        public static final String COINCIDE_CON = "<matches>";
        public static final String EMPIEZA_POR = "<starts>";
        public static final String FINALIZA_CON = "<ends>";
        public static final String TIENE_SUBCADENA = "<substring>";
    }

    public static abstract interface UCM_NUMBER_OPERATORS {
        public static final String MAYOR_QUE = ">";
        public static final String MAYOR_O_IGUAL_QUE = ">=";
        public static final String IGUAL_QUE = "=";
        public static final String MENOR_O_IGUAL_QUE = "<=";
        public static final String MENOR_QUE = "<";
    }
}


/* Location:              D:\OracleClaro\jdeveloper\ComponenteIntegracionUCM\ComponentesIntegracionUCM.jar!\co\com\soaint\compintucm\comun\Operators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */