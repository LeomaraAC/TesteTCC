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
    public static String prontuarioEditar = "cv1112000";
    public static String nomeEditadar = "User Editar Alterado";
    public static String emailEditadar = "editar.alterado@ifsp.com";
    public static String prontuarioAuxiliar = "cv1112200";

    //IDs e Xpath
    public static String idProntuario = "//input[contains(@id, 'prontuario')]";
    public static String idNome = "//input[contains(@id, 'nome')]";
    public static String idEmail = "//input[contains(@id, 'email')]";
    public static String idSenha = "//input[contains(@id, 'senha')]";
    public static String idSenhaConfirmation = "//input[contains(@id, 'senha_confirmation')]";
    public static String xpathMultiselect = "//div[@class='multiselect__select']";
    public static String xpathCombo = "//*[@class='multiselect__content']//li[*='Master']";

    //Xpath dos erros de validação dos campos
    public static String xpathErroCampoNome = "//input[@id='nome']/../../div[@class = 'erro']";
    public static String xpathErroCampoProntuario = "//input[@id='prontuario']/../../div[@class = 'erro']";
    public static String xpathErroCampoEmail = "//input[@id='email']/../../div[@class = 'erro']";
    public static String xpathErroCampoGrupo = "//div[@class='multiselect']/..//label[1]";

    //Mensagens
    public static String msgSucessoIncluir = "Usuário criado com sucesso!";
    public static String msgSucessoExcluir = "Usuário excluído com sucesso!";
    public static String msgSucessoEditar = "Usuário editado com sucesso!";
    public static String msgEmailRepetido = "O campo email já está sendo utilizado.";
    public static String msgProntuarioRepetido = "O campo prontuario já está sendo utilizado.";
    public static String msgProntuarioVazio = "O campo prontuario é obrigatório.";
    public static String msgNomeVazio = "O campo nome é obrigatório.";
    public static String msgEmailVazio = "O campo email é obrigatório.";
    public static String msgGrupoVazio = "O campo grupo é obrigatório.";

    //Tabela
    public static String colunaBusca = "Prontuário";


}
