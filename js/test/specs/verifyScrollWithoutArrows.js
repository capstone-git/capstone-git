const HomePage = require('../pageobjects/home.page');
var assert = require('assert');

describe('Verifying scroll without arrow keys', () => {
    it('should scroll up and down the home page without using arrow keys', async () => {
        await browser.maximizeWindow()
        await HomePage.open();

        // Scrolling to the bottom without down arrow key and verifying subscription
        await $('/html/body/footer/div[1]/div/div/div[2]/div/h2').scrollIntoView();
        // Verifies subscription title
        const title = await HomePage.subscriptionTitle();
        await assert.equal(title, 'SUBSCRIPTION');

        //Scrolling to the top without up arrow key and verifying Full-Fledged practice website for Automation Engineers text
        await $('/html/body/section[1]/div/div/div/div/div/div[1]/div[1]/h2').scrollIntoView();
        // Verifies top description text
        const topDesc = await HomePage.topDescriptionText();
        await assert.equal(topDesc, "Full-Fledged practice website for Automation Engineers");
    });
});