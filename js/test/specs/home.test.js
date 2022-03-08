
const HomePage = require('../pageobjects/home.page');

describe('Verify subscription function on Home page', () => {
    it('should all components of contact us page be visible', async () => {
        await HomePage.open()
        await HomePage.pressDown();
        await HomePage.textEmailSubscribe();
        await HomePage.clickButtonSubscribe();
        await expect(HomePage.getSuccessMessage).toHaveTextContaining('You have been successfully subscribed!')
    });
});
