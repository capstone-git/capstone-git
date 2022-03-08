const Page = require('./page');


class CartPage extends Page {

    open() {
        return super.open('view_cart');
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

module.exports = new CartPage();