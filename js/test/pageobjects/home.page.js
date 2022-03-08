const Page = require("./page");

/**
 * sub page containing specific selectors and methods for a specific page
 */
 class HomePage extends Page {
    /**
     * define selectors using getter methods
     */

    get testCasesbtn() {
        return $('/html/body/header/div/div/div/div[2]/div/ul/li[5]/a');
    }

    get subscription() {
        return $('/html/body/footer/div[1]/div/div/div[2]/div/h2');
    }

    get topDescription() {
        return $('/html/body/section[1]/div/div/div/div/div/div[1]/div[1]/h2');
    }

    /**
     * a method to encapsule automation code to interact with the page
     */
    async testCases () {
        await this.testCasesbtn.click();
    }

    async subscriptionTitle() {
        return await this.subscription.getText();
    }

    async topDescriptionText() {
        return await this.topDescription.getText();
    }

    async pressUp() {
        await browser.keys("\uE013");
    }

    async pressDown() {
        await browser.keys("\uE015")
    }

    async subscritpionScrollTo() {
        await this.subscription.scrollIntovView();
    }

    async topDescScrollTo() {
        await this.topDescription.scrollIntovView();
    }

}

module.exports = new HomePage();
