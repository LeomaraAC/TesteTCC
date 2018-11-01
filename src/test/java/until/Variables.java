package until;

public class Variables {
    /***Login***/
    public static  String login = "cv1002000";
    public static  String senha = "secret";
    public static String campoLogin = "//input[contains(@name, 'prontuario')]";
    public static String campoSenha = "//input[contains(@name, 'password')]";
    public static String btnEnviar = "//button[contains(@type, 'submit')]";
    public static String linkDropdown = "//li[contains(@class,'nav-item dropdown')]/a";
    public static String linkSair = "//form[contains(@id, 'logout-form')]/a";

    /***Menu***/
    public static String menuAdministracao = "//a[contains(text(), 'Administração')]";
    public static String menuUsuario = "//a[contains(text(), 'Usuários')]";
    public static String menuGrupo = "//a[contains(text(),'Grupos')]";
    public static String menuAluno = "//a[contains(text(),'Aluno')]";
    public static String menuAtendimento = "//a[contains(text(),'Atendimento')]";
    public static String menuTipos = "//a[contains(text(),'Tipos')]";

    /***Botões Novos***/
    public static String btnNovo = "//a[contains(@id, 'novo')]";
    public static String btnNovoTipo = "//a[contains(@id, 'novoTipo')]";

    /***Xpath***/
    public static String xpathMensagemSucesso = "//div[contains(@class, 'v-snack__wrapper green')]/div[contains(@class, 'v-snack__content')]/span";
    public static String xpathMensagemErro = "//div[contains(@class, 'v-snack__wrapper red')]/div[contains(@class, 'v-snack__content')]/span";

    /***IDs***/
    public static String idBtnSalvar = "//button[contains(@id, 'salvar')]";
    public static String idBtnLimpar = "//button[contains(@id, 'limpar')]";
    public static String idBtnFiltrar = "//div[contains(@id, 'btnInputFiltrar')]";

    //Xpath
    public static String xpathBusca = "//div[contains(@class, 'card-body')]//input[contains(@name, 'busca')]";

    //Tabela
    public static String xpathTabela = "//*[contains(@id, 'tabelaListagem')]//table";
    public static int idColunaExcluir = 1;
    public static int idColunaEditar = 2;
    public static String xpathByClickExcluir = ".//i";
    public static String xpathByClickEditar = ".//a";
    public static String xpathMsgTabelaSemElemento = "//*[contains(@id, 'tabelaListagem')]//table//tbody//div[contains(@class, 'v-alert red')]/div";
    public static String msgTabelaSemElemento = "Nenhum dado encontrado :(";
}
