![](./gateway.dio.png)

output from the order-service for a given id should be:

```json
{
  "orderId": 10248,
  "orderDate": "1996-07-03T18:30:00.000+00:00",
  "requiredDate": "1996-07-31T18:30:00.000+00:00",
  "shippedDate": "1996-07-15T18:30:00.000+00:00",
  "customer": {
    "customerId": "VINET",
    "companyName": "Vins et alcools Chevalier",
    "contactName": "Paul Henriot",
    "contactTitle": "Accounting Manager",
    "city": "Reims"
  },
  "shipper": {
    "shipperId": 3,
    "companyName": "Federal Shipping",
    "phone": "(503) 555-9931"
  },
  "freight": 32.38,
  "lineItems": [
    {
      "product": {
        "productId": 11,
        "productName": "Queso Cabrales",
        "unitPrice": 21.0,
        "quantityPerUnit": "1 kg pkg."
      },
      "unitPrice": 14.0,
      "quantity": 12,
      "discount": 0.0
    },
    {
      "product": {
        "productId": 42,
        "productName": "Singaporean Hokkien Fried Mee",
        "unitPrice": 14.0,
        "quantityPerUnit": "32 - 1 kg pkgs."
      },
      "unitPrice": 9.8,
      "quantity": 10,
      "discount": 0.0
    },
    {
      "product": {
        "productId": 72,
        "productName": "Mozzarella di Giovanni",
        "unitPrice": 34.8,
        "quantityPerUnit": "24 - 200 g pkgs."
      },
      "unitPrice": 34.8,
      "quantity": 5,
      "discount": 0.0
    }
  ]
}
```
