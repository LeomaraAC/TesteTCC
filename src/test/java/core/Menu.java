package core;

import until.Variables;

public class Menu extends Base {
    /***Tela de Usuário***/
    public void acessarTelaUsuario() {
        new Steps()
                .clicarBotaoMenu(Variables.menuAdministracao)
                .clicarBotaoMenu(Variables.menuUsuario);
    }

    public void acessarTelaInserirUsuario(){
        acessarTelaUsuario();
        new Steps()
                .clicarBotaoMenu(Variables.btnNovo);
    }

    /***Tela de Aluno***/
    public void acessarTelaAluno() {
        new Steps()
                .clicarBotaoMenu(Variables.menuAluno);
    }

    /***Tela de Atendimento***/
    public void acessarTelaAtendimento() {
        new Steps()
                .clicarBotaoMenu(Variables.menuAtendimento);

        new Steps()
                .clicarBotaoMenu(Variables.menuTipos);

    }

    public void acessarTelaInserirTipo() {
        acessarTelaAtendimento();
        new Steps()
                .clicarBotaoMenu(Variables.btnNovoTipo);
    }
}
