package objects;

public class TiposAtendimentoObject {
    //Dados
    public static String descricao = "Novo Tipo";
    public static String descricaoRepetida = "tipo existente";
    public static String descricaoCaracteresEspeciais = "soci@l*";
    public static String descricaoNumeros = "s0cial";
    public static String descricaoMinimo = "ok";
    public static String descricaoMaximo = "zxcvbnmlkjhgfdsaq ertyuiopçmnbvcxzasdf hjklçpoiuytrewqqwertyuiopçlkjh fdsazxcvbnmçlkjhgfdsaqw rtyuiopçlkjhgfdsaz cvbnm";

    //IDs e Xpath
    public static String idDescricao = "descricao";
    public static String xpathErroCampoDescricao = "//input[@id='descricao']/../../div[@class = 'erro']";

    //Mensagens sucesso
    public static String msgSucessoIncluir = "Tipo de atendimento criado com sucesso!";
    public static String msgErroTipoRepetido = "O campo descricao já está sendo utilizado.";
    public static String msgErroTipoVazio = "O campo descricao é obrigatório.";
    public static String msgErroTipoCaracteresEspeciais = "O campo descricao só pode conter caracteres alfabéticos e espaços.";
    public static String msgErroTipoNumero = "O campo descricao só pode conter caracteres alfabéticos e espaços.";
    public static String msgErroTipoMinimo = "O campo descricao deve conter pelo menos 3 caracteres.";

}
