package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.Test;

import static objects.AtendimentoObject.*;
import static until.Variables.*;

public class AtendimentoPage extends Base {
    private Menu menu = new Menu();

    private Steps DadosAgendamentos(String data, String horaInicio, String horaFim, String responsavel, String tipo) {
        return new Steps()
                .substituirValor(xpathData,data)
                .escrever(xpathHoraInicial,horaInicio)
                .escrever(xpathHoraFinal,horaFim)
                .clicarCombo(xpathComboResponsavel, responsavel)
                .clicarCombo(xpathComboTipo, tipo);

    }

    @Test
    public void testInserirAtendimentoConflitoNoIntervaloDeOutroTeste() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1700,
                hora1715,
                xpathOpcaoComboResponsavelSetor,
                xpathOpcaoComboTipoExistente
        )
                .clicarCombo(xpathComboAluno, xpathOpcaoComboFernando)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboLicenciaturaQuimica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgConflito);
        status = "OK";
    }

    @Test
    public void testInserirAtendimentoHoraFinalConflito() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1720,
                hora1750,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboAlana)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboADS)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgConflito);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoHoraInicilConflito() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1820,
                hora1840,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboHugo)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboTecnicoQuimica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgConflito);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoInicioAposFimConflitoNaHoraFinal() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1715,
                hora1750,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboHugo)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboLicenciaturaQuimica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgConflito);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoConflitoEnglobandoOutroAtendimento() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1840,
                hora1940,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboAlana)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboADS)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgConflito);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoConflitoInicioIgualInicioExistente() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1700,
                hora1720,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboFabiana)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboTecnicoInformatica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgConflito);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoConflitoAgendamentoContidoEmOutro() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1750,
                hora1820,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboFabiana)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboTecnicoInformatica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgConflito);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoConflitoComOutrosDoisAgendamentos() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1910,
                hora1925,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboFabiana)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboTecnicoInformatica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgConflito);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoSucesso() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1940,
                hora2000,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboAlana)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboADS)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoInserir);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoSucessoEntreDoisAgendamento() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2020,
                hora1715,
                hora1730,
                xpathOpcaoComboResponsavelSetor,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboFernando)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboLicenciaturaQuimica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoInserir);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoSucessoMesmaDataOutroAno() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2018,
                hora1700,
                hora1715,
                xpathOpcaoComboResponsavelSetor,
                xpathOpcaoComboTipoExistente
        )
                .clicarBotao(xpathCheckBoxFamilia)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboFernando)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboLicenciaturaQuimica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoInserir);
        status="OK";
    }

    @Test
    public void testInserirAtendimentoSucessoMesmaDataStatusCancelada() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2018,
                hora1730,
                hora1830,
                xpathOpcaoComboResponsavelParticular,
                xpathOpcaoComboTipoExistente
        )
                .clicarCombo(xpathComboAluno, xpathOpcaoComboFernando)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboLicenciaturaQuimica)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoInserir);
        status="OK";
    }

    @Test
    public void testInserirHoraFinalInferiorHoraInicial() {
        menu.acessarTelaInserirAgendamento();
        new Steps()
                .escrever(xpathHoraInicial, hora1715)
                .escrever(xpathHoraFinal, hora1700)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathLabelCampoErroHoraFinal,msgErroHoraFinlInferior);
        status = "OK";
    }

    @Test
    public void testInserirCamposbrigatorios() {
        menu.acessarTelaInserirAgendamento();
        new Steps()
                .clicarBotao(idBtnLimpar)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro,msgErroAlunoObrigatorio)
                .assertMSG(xpathLabelCampoErroData, msgErroDataObrigatoria)
                .assertMSG(xpathLabelCampoErroHoraInicial, msgErroHoraInicialObrigatorio)
                .assertMSG(xpathLabelCampoErroHoraFinal,msgErroHoraFinalObrigatorio)
                .assertMSG(xpathLabelCampoErroResponsavel, msgErroResponsavelObrigatorio)
                .assertMSG(xpathLabelCampoErroTipo, msgErroTipoObrigatorio);
        status = "OK";
    }

    @Test
    public void testInserirDataInvalida() {
        menu.acessarTelaInserirAgendamento();
        new Steps()
                .substituirValor(xpathData, dataInvalida)
                .removerFocus(xpathData)
                .assertMSG(xpathLabelCampoErroData, msgErroDataInvalida);
        status = "OK";
    }

    @Test
    public void testInserirHorasInvalida() {
        menu.acessarTelaInserirAgendamento();
        new Steps()
                .escrever(xpathHoraInicial, horaInicialInvalida)
                .escrever(xpathHoraFinal, horaFinalInvalida)
                .removerFocus(xpathHoraFinal)
                .assertMSG(xpathLabelCampoErroHoraInicial, msgErroHoraInicialInvalida)
                .assertMSG(xpathLabelCampoErroHoraFinal,msgErroHoraFinalInvalida);
        status = "OK";
    }

    @Test
    public void testInserirAlunoJaParticipanteDaReuniao() {
        menu.acessarTelaInserirAgendamento();
        DadosAgendamentos(
                data2018,
                hora1700,
                hora1715,
                xpathOpcaoComboResponsavelSetor,
                xpathOpcaoComboTipoExistente
        )
                .clicarCombo(xpathComboAluno, xpathOpcaoComboAlana)
                .clicarCombo(xpathComboCurso, xpathOpcaoComboADS)
                .substituirValor(xpathSemestre,semestre)
                .clicarBotao(xpathAdicionarAluno)
                .clicarCombo(xpathComboAluno, xpathOpcaoComboAlana)
                .assertMSG(xpathLabelCampoErroAluno, msgErroAlunoAllanaExistente);
        status = "OK";
    }


}
