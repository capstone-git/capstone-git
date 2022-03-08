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

    /**
     * a method to encapsule automation code to interact with the page
     */
    async testCases () {
        await this.testCasesbtn.click();
    }
    
}

module.exports = new HomePage();
