Feature: Create Invoice

Scenario: Create Invoice for Matter
When I create an invoice for matter "M1" with vendor "<company_name>" for template "<invoice_template>" and template type "<invoice_template_type>"
| invoice_date | vendor_tax_reg | billing_office_name | currency_type | start_date | end_date   |
|   |                |                     | USD           | 06/07/2023 | 07/07/2023 |
When I add  line item to the invoice with "<template_name>"
| fee_amount | fee_narrative | expense_amount | expense_narrative | charge_date  | task      | activity                     |
|            |               |                | 				  | 06/07/2023   | Fee - Fee | A105 - Communicate (in firm) |
Then I save the invoice and name it as inv1
Then I submit the invoice inv1 for review
Then I validate alert invoice message
Then I click on the link and redirect to the respective page
Then I approve the invoice
When I add reject the invoice as per the below table:"
| RejectOption       | Reason                       | Narrative               | LineItemNos | IsLineItemWindow |
| Selected Line Item | Alternative Fee Arrangement  | Test reject by invoice  | all        | true            |
