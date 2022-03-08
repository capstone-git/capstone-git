
const CartPage = require('../pageobjects/cart.page');

describe('Verify component visibility', () => {
    it('Verify subscription function on Cart page', async () => {
        await CartPage.open();
        await CartPage.pressDown();
        await CartPage.textEmailSubscribe();
        await CartPage.clickButtonSubscribe();
        await expect(CartPage.getSuccessMessage).toHaveTextContaining('You have been successfully subscribed!')
    });
});
