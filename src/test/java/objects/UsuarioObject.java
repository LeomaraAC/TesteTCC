package objects;

public class UsuarioObject {
    //Dados
    public static String nome = "Novo Useruário";
    public static String prontuario = "cv12345";
    public static String email = "novouser@yahoo.com";
    public static String senhaUser = "secret";
    public static String emailRepetido = "master@ifsp.com";
    public static String prontuarioRepetido = "cv1002000";
    public static String prontuarioExcluir = "cv1102000";

    //IDs e Xpath
    public static String idProntuario = "prontuario";
    public static String idNome = "nome";
    public static String idEmail = "email";
    public static String idSenha = "senha";
    public static String idSenhaConfirmation = "senha_confirmation";
    public static String xpathMultiselect = "//div[@class='multiselect__select']";
    public static String xpathCombo = "//*[@class='multiselect__content']//li[*='Master']";
    public static String xpathTabela = "//*[@id='tabelaListagem']//table";

    //Mensagens sucesso
    public static String msgSucessoIncluir = "Usuário criado com sucesso!";
    public static String msgSucessoExcluir = "Usuário excluído com sucesso!";
    public static String msgEmailRepetido = "O campo email já está sendo utilizado.";
    public static String msgProntuarioRepetido = "O campo prontuario já está sendo utilizado.";

}
