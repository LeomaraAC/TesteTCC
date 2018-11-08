package core;

import static until.Variables.*;

public class Menu extends Base {
    /***Tela de Usuário***/
    public void acessarTelaUsuario() {
        new Steps()
                .clicarBotaoMenu(menuAdministracao)
                .clicarBotaoMenu(menuUsuario);
    }

    public void acessarTelaInserirUsuario() {
        acessarTelaUsuario();
        new Steps()
                .clicarBotaoMenu(btnNovo);
    }

    /***Tela de Grupo***/
    public void acessarTelaGrupo() {
        new Steps()
                .clicarBotaoMenu(menuAdministracao)
                .clicarBotaoMenu(menuGrupo);
    }

    public void acessarTelaInserirGrupo() {
        acessarTelaGrupo();
        new Steps()
                .clicarBotaoMenu(btnNovo);
    }

    /***Tela de Aluno***/
    public void acessarTelaAluno() {
        new Steps()
                .clicarBotaoMenu(menuAluno);
    }

    /***Tela do Tipo de Atendimento ***/
    public void acessarTelaTipoAtendimento() {
        new Steps()
                .clicarBotaoMenu(menuAtendimento)
                .clicarBotaoMenu(menuTipos);

    }

    public void acessarTelaInserirTipo() {
        acessarTelaTipoAtendimento();
        new Steps()
                .clicarBotaoMenu(btnNovoTipo);
    }

    /*** Tela de Agendamento ***/
    public void acessarTelaAgendamento() {
        new Steps()
                .clicarBotaoMenu(menuAtendimento)
                .clicarBotaoMenu(menuAgendamento);
    }

    public void acessarTelaInserirAgendamento() {
        acessarTelaAgendamento();
        new Steps()
                .clicarBotaoMenu(btnNovoAgendamento);
    }
}
