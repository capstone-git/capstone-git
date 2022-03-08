
const ContactUs = require('../pageobjects/contact.us.page');

describe('Verify component visibility', () => {
    it('should all components of contact us page be visible', async () => {
        await ContactUs.open();
        await expect(ContactUs.getContactUsTitle).toHaveTextContaining('CONTACT US');
        await expect(ContactUs.getInTouchTitle).toHaveTextContaining('GET IN TOUCH')
        await expect(ContactUs.getFeedbackForUsTitle).toHaveTextContaining('FEEDBACK FOR US')
        await expect(ContactUs.getFeedbackMessageP1).toHaveTextContaining('We really appreciate your response to our website.')
        await expect(ContactUs.getFeedbackMessageP2).toHaveTextContaining('Kindly share your feedback with us at feedback@automationexercise.com.')
        await expect(ContactUs.getFeedbackMessageP3).toHaveTextContaining('If you have any suggestion areas or improvements, do let us know. We will definitely work on it.')
        await expect(ContactUs.getFeedbackMessageP4).toHaveTextContaining('Thank you')
        await expect(ContactUs.getNameTextField).toBeDisplayed();
        await expect(ContactUs.getEmailTextField).toBeDisplayed();
        await expect(ContactUs.getSubjectTextField).toBeDisplayed();
        await expect(ContactUs.getMessageTextField).toBeDisplayed();
        await expect(ContactUs.getChooseFileButton).toBeDisplayed();
        await expect(ContactUs.getSubmitButton).toBeDisplayed();
    });
});

describe('Verify contact form message composition', () => {
    it('The components of contact us page be visible', async () => {
        await ContactUs.open();
        await ContactUs.textName();
        await ContactUs.textEmail();
        await ContactUs.textSubject();
        await ContactUs.textMessage();
        await ContactUs.attachFile();
        await ContactUs.clickSubmit();
        await ContactUs.acceptAlert();
        await expect(ContactUs.getSuccessMessageTitle).toHaveTextContaining('Success! Your details have been submitted successfully.')
    });
});



