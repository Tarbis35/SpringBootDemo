package co.com.utils.ucm.common;

public abstract interface Metadata {
    public static abstract interface UCM_VIEWS {
        public static final String VTIPOS = "DocTypes";
        public static final String VSUBTIPOS = "xvSubTipos";
        public static final String VDOCUMENTOS = "xvDocumentos";
        public static final String FUNCIONARIOS = "xvFuncionarios";
    }

    public static abstract interface UCM_CUSTOM {
        public static final String NUMERO_RADICADO = "xNumRadicado";
        public static final String PERFIL = "xIdcProfile";
        public static final String COMENTARIOS = "xComments";
        public static final String SUBTIPO = "xSubTipo";
        public static final String DOCUMENTO = "xDocumento";
        public static final String ID_CLIENTE = "xNumIdEntidad";
        public static final String NOMBRE_CLIENTE = "xNombreEntidad";
        public static final String ID_NEGOCIO = "xIdNegocio";
        public static final String NOMBRE_NEGOCIO = "xNomNegocio";
        public static final String TIPO_NEGOCIO = "xTipoNegocio";
        public static final String SUBTIPO_NEGOCIO = "xSubTipoNegocio";
        public static final String ENTE_CONTROL = "xEnteControl";
        public static final String TIPO_PLANTILLA = "xPlatTipo";
        public static final String SUBTIPO_PLANTILLA = "xPlatSubtipo";
        public static final String DOCUMENTO_PLANTILLA = "xPlatDocumento";
        public static final String NOMBRE_FUNCIONARIO_ENCARGADO = "xNomFunEncargado";
        public static final String NUMERO_CONTRATO = "xNumContrato";
        public static final String ESTADO_CONTRATO = "xEstadoContrato";
    }

    public static abstract interface UCM_OPTIONAL {
        public static final String DOCCREATOR = "dDocCreator";
        public static final String REVCLASSID = "dRevClassID";
        public static final String PUBLISHTYPE = "dPublishType";
        public static final String WEBEXTENSION = "dWebExtension";
        public static final String FORMAT = "dFormat";
        public static final String CREATEDATE = "dCreateDate";
        public static final String DOCFUNCTION = "dDocFunction";
        public static final String DOCLASTMODIFIER = "dDocLastModifier";
        public static final String DOCLASTMODIFIEDDATE = "dDocLastModifiedDate";
        public static final String FULLTEXTFORMAT = "dFullTextFormat";
        public static final String RENDITION1 = "dRendition1";
        public static final String RENDITION2 = "dRendition2";
        public static final String REVISIONID = "dRevisionID";
        public static final String OUTDATE = "dOutDate";
        public static final String OTSLANGUAGE = "otsLanguage";
        public static final String OTSCHARSET = "otsCharset";
        public static final String GIF = "dGif";
        public static final String OTSFORMAT = "otsFormat";
        public static final String ID = "dID";
        public static final String SRFDOCSNIPPET = "srfDocSnippet";
        public static final String URL = "URL";
        public static final String SCORE = "SCORE";
        public static final String INDATE = "dInDate";
        public static final String DOCOWNER = "dDocOwner";
        public static final String ALTERNATEFORMAT = "AlternateFormat";
        public static final String EXTENSION = "dExtension";
        public static final String WEBFILESIZE = "WebFileSize";
        public static final String VAULTFILESIZE = "VaultFileSize";
        public static final String FULLNAME = "dFullName";
        public static final String NAME = "dName";
        public static final String DESCRIPCION = "dDescription";
        public static final String SUBT_ID = "sub_id";
        public static final String SUBT_DESCRIPCION = "sub_descripcion";
        public static final String DOC_ID = "Doc_Id";
        public static final String DOC_DESCRIPCION = "doc_descripcion";
        public static final String DOC_STATUS = "dStatus";
    }

    public static abstract interface UCM_MANDATORY {
        public static final String ORIGINAL_NAME = "dOriginalName";
        public static final String DOC_TITLE = "dDocTitle";
        public static final String DOC_ID = "dID";
        public static final String REV_LABEL = "dRevLabel";
        public static final String DOC_NAME = "dDocName";
        public static final String DOC_TYPE = "dDocType";
        public static final String DOC_AUTHOR = "dDocAuthor";
        public static final String SECURITY_GROUP = "dSecurityGroup";
        public static final String DOC_ACCOUNT = "dDocAccount";
    }
}
