const Page = require('./page');

class HomePage extends Page {
    /**
     * define selectors using getter methods
     */

    get testCasesbtn() {
        return $('/html/body/header/div/div/div/div[2]/div/ul/li[5]/a');
    }

    /**
     * a method to encapsule automation code to interact with the page
     */
    async testCases () {
        await this.testCasesbtn.click();
    }

    open() {
        return super.open('');
    }

    async textEmailSubscribe() {
        await this.getEmailSubscribe.setValue('exaple@exaple.com');
    }

    async clickButtonSubscribe() {
        await this.getButtonSubscribe.click();
    }

    get getEmailSubscribe() {
        return $('//input[@id=\'susbscribe_email\']');
    }

    get getButtonSubscribe() {
        return $('//button[@id=\'subscribe\']');
    }

    get getSuccessMessage() {
        return $('//div[@class=\'alert-success alert\']');
    }

    async pressDown() {
        await browser.keys("\uE015")
    }

}

module.exports = new HomePage();