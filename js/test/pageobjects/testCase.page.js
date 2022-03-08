const Page = require("./page");

/**
 * sub page containing specific selectors and methods for a specific page
 */
 class TestCase extends Page {
    /**
     * define selectors using getter methods
     */

    get testCasesTitle() {
        return $('/html/body/section/div/div[1]/div/h2/b');
    }

    /**
     * a method to encapsule automation code to interact with the page
     */
    async title () {
       return await this.testCasesTitle.getText();
    }
    
}

module.exports = new TestCase();