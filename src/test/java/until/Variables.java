package until;

public class Variables {
    /***Login***/
    public static  String login = "cv1002000";
    public static  String senha = "secret";
    public static String campoLogin = "//input[@name='prontuario']";
    public static String campoSenha = "//input[@name='password']";
    public static String btnEnviar = "//button[@type='submit']";
    public static String linkDropdown = "//li[@class='nav-item dropdown']/a";
    public static String linkSair = "//form[@id='logout-form']/a";

    /***Menu***/
    public static String menuAdministracao = "//a[.='Administração']";
    public static String menuUsuario = "//a[.='Usuários']";
    public static String menuAluno = "//a[.='Aluno']";
    public static String menuAtendimento = "//a[.='Atendimento']";
    public static String menuTipos = "//a[.='Tipos']";

    /***Botões Novos***/
    public static String btnNovo = "//a[@id='novo']";
    public static String btnNovoTipo = "//a[@id='novoTipo']";

    /***Xpath***/
    public static String xpathMensagemSucesso = "//div[@class='v-snack__wrapper green']/div[@class='v-snack__content']/span";
    public static String xpathMensagemErro = "//div[@class='v-snack__wrapper red']/div[@class='v-snack__content']/span";

    /***IDs***/
    public static String idBtnSalvar = "salvar";
    public static String idBtnLimpar = "limpar";
    public static String idBtnFiltrar = "btnInputFiltrar";

    //Xpath
    public static String xpathBusca = "//div[@class='card-body']//input[@name='busca']";

    //Tabela
    public static String xpathTabela = "//*[@id='tabelaListagem']//table";
    public static int idColunaExcluir = 1;
    public static int idColunaEditar = 2;
    public static String xpathByClickExcluir = ".//i";
    public static String xpathByClickEditar = ".//a";
    public static String xpathMsgTabelaSemElemento = "//*[@id='tabelaListagem']//table//tbody//div[@class='v-alert red']/div";
    public static String msgTabelaSemElemento = "Nenhum dado encontrado :(";
}
