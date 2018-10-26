package objects;

public class GrupoObject {
    //Dados
    public static String nome = "Novo Grupo";
    public static String permissaoApagarUsuario = "Apagar usuário";
    public static String permissaoImportarDados = "Importar dados dos alunos";
    public static String permissaoIncluirUsuario = "Incluir usuário";

    //IDs e Xpath
    public static String idNome = "//input[contains(@name, 'grupo')]";
    public static String idBuscaPermissoes = "//input[contains(@name, 'busca')]";
    public static String idBtnAdicionar = "//button[contains(@id, 'adicionar')]";
    public static String idBtnFecharModal = "//div[contains(@class, 'modal-header')]//button[contains(@class, 'close')]";

    // Messagens
    public static String msgSemPermissoes = "Selecione pelo menos uma permissão para poder continuar";

}
