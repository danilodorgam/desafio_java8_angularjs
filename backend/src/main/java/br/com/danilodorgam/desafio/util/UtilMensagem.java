package br.com.danilodorgam.desafio.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.danilodorgam.desafio.util.Mensagem.TipoMensagem;

public class UtilMensagem {

    private static ResourceBundle mensages = ResourceBundle.getBundle("ValidationMessages");

    public static Mensagem getMensagem(String message, TipoMensagem tipo) {
        return getMensagem(message, tipo, null);
    }

    public static Mensagem getMensagem(String message, TipoMensagem tipo, String campo) {
        String mensagem;
        TipoMensagem tipoMensagem;

        boolean isKey = mensages.containsKey(message);
        if(isKey) {
            String valor = MessageFormat.format(mensages.getString(message), campo);
            String[] msg = valor.split("--");
            if(msg.length>1) {
                String tipoContesto = msg[0].trim();

                if("A".equals(tipoContesto)) {

                    tipoMensagem = TipoMensagem.AVISO;
                }else if("I".equals(tipoContesto)) {

                    tipoMensagem = TipoMensagem.INFO;
                }else {

                    tipoMensagem = TipoMensagem.ERRO;
                }
                mensagem = campo!=null?campo+":"+msg[1]:msg[1];
            }else {
                mensagem =  campo!=null?campo+":"+valor:valor;
                tipoMensagem = tipo;
            }

        }else {

            mensagem = message;
            tipoMensagem = tipo;
        }
        return new Mensagem(tipoMensagem, mensagem);
    }

    public static Mensagem getMensagem(String[] args, String message, TipoMensagem tipo) {
        String mensagem;
        TipoMensagem tipoMensagem;

        boolean isKey = mensages.containsKey(message);
        if(isKey) {
            String valor = MessageFormat.format(mensages.getString(message), args);
            String[] msg = valor.split("--");
            if(msg.length>1) {
                String tipoContesto = msg[0].trim();

                if("A".equals(tipoContesto)) {

                    tipoMensagem = TipoMensagem.AVISO;
                }else if("I".equals(tipoContesto)) {

                    tipoMensagem = TipoMensagem.INFO;
                }else {

                    tipoMensagem = TipoMensagem.ERRO;
                }
                mensagem = msg[1];
            }else {
                mensagem =  valor;
                tipoMensagem = tipo;
            }

        }else {

            mensagem = message;
            tipoMensagem = tipo;
        }
        return new Mensagem(tipoMensagem, mensagem);
    }

    public static String geraCodigoUnicode(char letra) {
        String hexa = Integer.toHexString( (int)letra );

        String prefix;
        if( hexa.length() == 1 ) {
            prefix = "\\u000";
        } else if( hexa.length() == 2 ) {
            prefix = "\\u00";
        } else if( hexa.length() == 3 ) {
            prefix = "\\u0";
        } else {
            prefix = "\\u";
        }

        return prefix + hexa;
    }

    public static String trocaPorUnicode(String texto) {
        String caracteres = "ŠŽšžŸÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜÏÖÑÝåáçéíóúàèìòùâêîôûãõëüïöñýÿ";
        for(int i = 0; i < caracteres.length();i++){
            String letra = caracteres.substring(i, i+1);
            String codigo = geraCodigoUnicode( letra.charAt(0) ) ;
            texto = texto.replaceAll(letra, "\\"+codigo);
        }
        return texto;
    }

    public static void main(String[] args) {
        String texto = "Š Ž š ž Ÿ Á Ç É Í Ó Ú À È Ì Ò Ù Â Ê Î Ô Û Ã Õ Ë Ü Ï Ö Ñ Ý å á ç é í ó ú à è ì ò ù â ê î ô û ã õ ë ü ï ö ñ ý ÿ";
        System.out.println(texto);
        System.out.println(trocaPorUnicode(texto));
    }
}
