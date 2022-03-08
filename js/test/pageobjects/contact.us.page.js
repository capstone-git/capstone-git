const Page = require('./page');


class ContactUsPage extends Page {

    open() {
        return super.open('contact_us');
    }

    async textName() {
        await this.getNameTextField.setValue('Alex');
    }

    async textEmail() {
        await this.getEmailTextField.setValue('exaple@exaple.com');
    }

    async textSubject() {
        await this.getSubjectTextField.setValue('Subject');
    }

    async textMessage() {
        await this.getMessageTextField.setValue('Message');
    }

    async clickSubmit(){
        await this.getSubmitButton.click();
    }

    get getSuccessMessageTitle() {
        return $('//div[@class=\'status alert alert-success\']');
    }

    get getContactUsTitle() {
        return $('(//h2[@class=\'title text-center\'])[1]');
    }

    get getInTouchTitle() {
        return $('(//h2[@class=\'title text-center\'])[2]');
    }

    get getFeedbackForUsTitle() {
        return $('(//h2[@class=\'title text-center\'])[3]');
    }

    get getNoteMessage() {
        return $('(//div[@class=\'contact-form\']/div)[1]');
    }

    get getNameTextField() {
        return $('//input[@name=\'name\']');
    }

    get getEmailTextField() {
        return $('//input[@name=\'email\']');
    }

    get getSubjectTextField() {
        return $('//input[@name=\'subject\']');
    }

    get getChooseFileButton() {
        return $('//input[@type=\'file\']');
    }

    get getSubmitButton() {
        return $('//input[@type=\'submit\']');
    }

    get getMessageTextField() {
        return $('//textarea[@name=\'message\']');
    }

    get getFeedbackMessageP1() {
        return $('//div[@class=\'contact-info\']/address/p[1]');
    }

    get getFeedbackMessageP2() {
        return $('//div[@class=\'contact-info\']/address/p[2]');
    }

    get getFeedbackMessageP3() {
        return $('//div[@class=\'contact-info\']/address/p[3]');
    }

    get getFeedbackMessageP4() {
        return $('//div[@class=\'contact-info\']/address/p[4]');
    }

}

module.exports = new ContactUsPage();
