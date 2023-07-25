Feature: Invoice Creation and Submission

    Then passing username
    Then I create invoice for matter "M1" with vendor "<company_name>" for template "<invoice_template>"
    Then Passing password
    Then I submit the invoice "inv1" for review
    Then I click on the link "" and redirect to the respective page
    Then I validate alert message
    Then I approve the invoice
    Then I add  line item to the invoice with template "Task and activity"
    Then I reject the invoice 
    Then I save the invoice and name it as "inv1"
