package objects;

public class AtendimentoObject {
    //Valores
    public static String data2020 = "06112020";
    public static String data2018 = "06112018";
    public static String dataInvalida = "991901";
    public static String horaInicialInvalida = "9919";
    public static String horaFinalInvalida = "1599";
    public static String hora1700 = "1700";
    public static String hora1715 = "1715";
    public static String hora1720 = "1720";
    public static String hora1730 = "1730";
    public static String hora1750 = "1750";
    public static String hora1820 = "1820";
    public static String hora1830 = "1830";
    public static String hora1840 = "1840";
    public static String hora1910 = "1910";
    public static String hora1925 = "1925";
    public static String hora1940 = "1940";
    public static String hora2000 = "2000";
    public static String semestre = "2";

    //Xpath dos campos
    public static String xpathData = "//input[contains(@id,'data')]";
    public static String xpathHoraInicial = "//input[contains(@id,'horaInicial')]";
    public static String xpathHoraFinal = "//input[contains(@id,'horaFinal')]";
    public static String xpathCheckBoxFamilia = "//label[contains(text(), 'Atendimento com a família')]";
    public static String xpathSemestre = "//input[contains(@id, 'semestre')]";
    public static String xpathAdicionarAluno = "//button[contains(@id, 'adicionarAluno')]";

    public static String xpathComboResponsavel = "//*[contains(@id, 'responsavel')]/../../div[contains(@class, '__select')]";
    public static String xpathOpcaoComboResponsavelSetor = "//*[contains(@id, 'responsavel')]/../..//*[@class='multiselect__content']//li[*='Setor']";
    public static String xpathOpcaoComboResponsavelParticular = "//*[contains(@id, 'responsavel')]/../..//*[@class='multiselect__content']//li[*='Particular']";

    public static String xpathComboTipo = "//*[contains(@id, 'tipo')]/../../div[contains(@class, '__select')]";
    public static String xpathOpcaoComboTipoExistente = "//*[contains(@id, 'tipo')]/../..//*[@class='multiselect__content']//li[*= 'tipo existente']";

    public static String xpathComboAluno = "//*[contains(@id, 'aluno')]/../../div[contains(@class, '__select')]";
    public static String xpathOpcaoComboAlana = "//*[contains(@id, 'aluno')]/../..//*[@class='multiselect__content']//li[*= 'Allana Márcia Araujo Rocha']";
    public static String xpathOpcaoComboFernando = "//*[contains(@id, 'aluno')]/../..//*[@class='multiselect__content']//li[*= 'Fernando Bryan Nelson Vieira']";
    public static String xpathOpcaoComboHugo = "//*[contains(@id, 'aluno')]/../..//*[@class='multiselect__content']//li[*= 'Hugo Henry Anderson Freitas']";
    public static String xpathOpcaoComboFabiana = "//*[contains(@id, 'aluno')]/../..//*[@class='multiselect__content']//li[*= 'Fabiana Nina Jéssica da Paz']";

    public static String xpathComboCurso = "//*[contains(@id, 'curso')]/../../div[contains(@class, '__select')]";
    public static String xpathOpcaoComboADS = "//*[contains(@id, 'curso')]/../..//*[@class='multiselect__content']//li//span[contains(text(), 'DESENVOLVIMENTO DE SISTEMA')]";
    public static String xpathOpcaoComboTecnicoQuimica = "//*[contains(@id, 'curso')]/../..//*[@class='multiselect__content']//li//span[contains(text(), 'TÉCNICO EM QUÍMICA')]";
    public static String xpathOpcaoComboTecnicoInformatica = "//*[contains(@id, 'curso')]/../..//*[@class='multiselect__content']//li//span[contains(text(), 'TÉCNICO EM MANUTENÇÃO E SUPORTE EM INFORMÁTICA')]";
    public static String xpathOpcaoComboLicenciaturaQuimica = "//*[contains(@id, 'curso')]/../..//*[@class='multiselect__content']//li//span[contains(text(), 'LICENCIATURA EM QUÍMICA')]";

    //Xpath dos labels de erro
    public static String xpathLabelCampoErroData = "//input[@id='data']/../../div[@class = 'erro']";
    public static String xpathLabelCampoErroHoraInicial = "//input[@id='horaInicial']/../../div[@class = 'erro']";
    public static String xpathLabelCampoErroHoraFinal = "//input[@id='horaFinal']/../../div[@class = 'erro']";
    public static String xpathLabelCampoErroResponsavel = "//*[contains(@id, 'responsavel')]/../../div[contains(@class, '__select')]/../..//label[1]";
    public static String xpathLabelCampoErroTipo = "//*[contains(@id, 'tip')]/../../div[contains(@class, '__select')]/../..//label[1]";
    public static String xpathLabelCampoErroAluno = "//*[contains(@id, 'aluno')]/../../div[contains(@class, '__select')]/../..//label[2]";
    //Mensagens
    public static String msgConflito = "A hora agendada para reunião entra em conflito com outra reunião!";
    public static String msgErroHoraInicialInvalida = "O valor do campo horário inicial é inválido.";
    public static String msgErroHoraFinlInferior = "O termino da reunião deve ser posterior ao seu início.";
    public static String msgErroHoraFinalInvalida = "O valor do campo horário final é inválido.";
    public static String msgErroDataInvalida = "O valor do campo data é inválido.";
    public static String msgErroAlunoObrigatorio = "Pelo menos um aluno deve participar da reunião!";
    public static String msgErroAlunoAllanaExistente = "Aluno Allana Márcia Araujo Rocha já está selecionado!";
    public static String msgErroDataObrigatoria = "O campo data é obrigatório.";
    public static String msgErroHoraInicialObrigatorio = "O campo horário inicial é obrigatório.";
    public static String msgErroHoraFinalObrigatorio = "O campo horário final é obrigatório.";
    public static String msgErroResponsavelObrigatorio = "O campo responsável é obrigatório.";
    public static String msgErroTipoObrigatorio = "O campo tipo é obrigatório.";
    public static String msgSucessoInserir = "Reunião agendada com sucesso!";
}
