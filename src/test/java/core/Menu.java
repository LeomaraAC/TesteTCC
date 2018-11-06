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

    /***Tela de Atendimento***/
    public void acessarTelaAtendimento() {
        new Steps()
                .clicarBotaoMenu(menuAtendimento);

        new Steps()
                .clicarBotaoMenu(menuTipos);

    }

    public void acessarTelaInserirTipo() {
        acessarTelaAtendimento();
        new Steps()
                .clicarBotaoMenu(btnNovoTipo);
    }
}
