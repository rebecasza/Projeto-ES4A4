import {browser, by, element} from 'protractor';

export class LoginPage{
    navegarParaLogin(){
        return browser.get('/login')
    }

    obterOtextoLogin(){
        return element(by.css('#registrar')).getText();
    }

    esperar = (milisegundos:number) => {
        browser.sleep(milisegundos);
    }
    
    registrar = element(by.css('#registrar'));
    nome = element(by.css('#nome'));
    sobrenome = element(by.css("#sobrenome"));
    email = element(by.css('#email'));
    senha = element(by.css("#senha"));
    submeter = element(by.css("#submeter"));
}