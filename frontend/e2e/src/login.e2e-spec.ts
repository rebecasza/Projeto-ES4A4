import {LoginPage} from './login.po';

describe('tela de login', () =>{
    let pagina: LoginPage;

    beforeEach(() => {
        pagina = new LoginPage();
    })

    it('deve verificar se existe o texto esqueci a senha', () => {
        pagina.obterOtextoLogin();
        expect(pagina.obterOtextoLogin()).toEqual('Sign Up');
    });

    it('deve clicar no botão esqueci senha e preencher o formulário', () => {
        pagina.esperar(5000);
        pagina.registrar.click();
        pagina.esperar(7000);
        pagina.nome.sendKeys("Rebeca");
        pagina.sobrenome.sendKeys("Souza");
        pagina.email.sendKeys("becasouza.ds@hotmail.com");
        pagina.senha.sendKeys("123");
        pagina.submeter.click();

    });
});