# Tasks   

total time: 272min

## /products  

time：60min

- post()

  1. return 201

     - return 201 when create product — 5 5

     - return uri when create product — 5 6

     - save and find product in product repository  — 15 18

       (ProductRepository.createProduct,

       ProductMapper.save,

       ProductMapper.findById)

     - return 201 when create product with specified parameter — 5 2

  2. return 400

     - return 400 when name, description or price is null — 15 18

       (Exception handling)

     ​

- get()

  1. return 200

     - return 200 when get products — 3 3

     - get products in product repository — 7 3

       (ProductRepository.getAllProducts,

       ProductMapper.getAll)

     - return detail when get products — 5 5

       (toJason, toRefJason)

       ​

## /products/{productId}

time：12min

- get()

  1. return 200

     - return 200 when get product — 5 3

     - find product in product repository  — 5 3

       ((Optional)ProductRepository.findProductById)

     - return detail when get product — 3 3

  2. return 404

     - return 404 when no product exists — 5 3

  ​

## /users

time: 25min

- post()

  1. return 201

     - return 201 when create user — 5 5

     - return uri when create user — 10 6

     - save and find user in user repository  — 15 9

       (UserRepository.createUser,

       UserMapper.save,

       UserMapper.findById)

     - return 201 when create user with specified parameter — 3 2

  2. return 400

     - return 400 when name is null — 5 3

       ​

## /users/{userId}

time: 14min

- get()

  1. return 200

     - return 200 when find user by id — 3 5

     - find user by id in user repository — 5 3

       (UserRepository.findUserById)

     - return details when find user by id — 5 4

  2. return 404

     - return 404 when user not exists — 5 2



## /users/{id}/orders

time: 93min

- post()

  1. return 201

     - return 201 when create order — 5 7

     - return uri when create order — 15 9

     - save and find order in user — 20 53

       (User.createOrder,

       OrderMapper.save,

       OrderMapper.findById)

     - return 201 when create oder with specified parameter — 5 3

  2. return 400

     - return 400 when name, address, phone or order_items is null — 5 4

     ​

- get()

  1. return 200

     - return 200 when get orders — 3 3

     - get orders in user repository in user — 10 8

       (User.getAllOrders,

       OrderMapper.getAll)

     - return detail when get orders — 5 6

     ​

## /users/{id}/orders/{orderId}

time: 17min

- get()

  1. return 200

     - return 200 when find order by id— 3 2

     - find order by order_id in user  — 5 3

       (User.findOrderById)

     - return detail when get order — 5 10

  2. return 404 when no order exists — 3 2

     ​

## /users/{id}/orders/{orderId}/payments

time:51min

- post()

  1. return 201

     - return 201 when create payment — 5 5

     - return uri when create payment — 10 7

     - save payment in order — 15 13

       (Order.createPayment,

       PaymentMapper.save,

       PaymentMapper.findById)

     - return 201 when create payment with specified parameter — 3 3

  2. return 400

     - return 400 when pay_type or amount is null — 5 5

     ​

- get()

  1. return 200

     - return 200 when get payment — 3 3

     - find payment in order — 5 5

       (Order.getPayment)

     - return details when get payment — 5 7

  2. return 404 when no payment exists — 3 3



