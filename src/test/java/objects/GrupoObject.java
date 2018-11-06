package objects;

public class GrupoObject {
    //Dados
    public static String nome = "Novo Grupo";
    public static String nomeRepetido = "Grupo repetido";
    public static String nomeMinimo = "um";
    public static String nomeMaximo = "Perder tempo em aprender coisas que não interessam, priva-nos de descobrir coisas interessantes.";
    public static String nomeComNumero = "Grupo 123";
    public static String nomeComTraco = "micro-ônibus";
    public static String nomeComCaracteresEspeciais = "#0l@Mund0";
    public static String nomeEditar = "Grupo Editar Alterado";
    public static String nomeEditarSemAlterarPermissoes = "Grupo Editar Sem alterar Alterado";

    public static String grupoEditar = "Grupo Editar";
    public static String grupoEditarSemAlterarPermissoes = "Grupo editar sem Alterar Permissões";
    public static String grupoExcluir = "Grupo Excluir";

    public static String[] permissoesInserir = {
            "Apagar usuário",
            "Importar dados dos alunos",
            "Incluir usuário",
            "Apagar grupo",
            "Visualizar aluno",
            "Editar tipo de atendimento",
            "Agendamento de atendimentos",
            "Incluir grupo"
    };
    public static String[] poucasPermissoes = {
            "Apagar usuário",
            "Importar dados dos alunos",
            "Incluir grupo"
    };

    public static String[] permissoesEditar = {
            "incluir tipo de Atendimento",
            "Agendamento de Atendimentos",
            "Incluir Usuário"
    };

    public static int indiceDesmarcar = 2;

    //IDs e Xpath
    public static String idNome = "//input[contains(@name, 'grupo')]";
    public static String idBuscaPermissoes = "//input[contains(@name, 'busca')]";
    public static String idBtnAdicionar = "//button[contains(@id, 'adicionar')]";
    public static String idBtnFecharModal = "//div[contains(@class, 'modal-header')]//button[contains(@class, 'close')]";
    public static String xpathCheckBox = "/span/label[contains(@class,'check')]/span";
    public static int idColunaMarcarDesmarcar = 1;
    public static String colunaBuscaPermissoes = "Permissões";
    public static String colunaBuscaGrupo = "Grupo";
    public static String xpathErroCampoNome = "//input[@name='grupo']/../../div[@class = 'erro']";

    // Messagens
    public static String msgSucessoIncluir = "Grupo criado com sucesso!";
    public static String msgSucessoEditar = "Grupo editado com sucesso!";
    public static String msgSucessoExcluir = "Grupo excluído com sucesso!";
    public static String msgSemPermissoes = "Selecione pelo menos uma permissão para poder continuar";
    public static String msgCampoObrigatorio = "O campo grupo é obrigatório.";
    public static String msgGrupoRepetido = "O campo grupo já está sendo utilizado.";
    public static String msgNomeInvalido = "O campo grupo possui um formato inválido.";
    public static String msgNomeMinimo = "O campo grupo deve conter pelo menos 3 caracteres.";

}
