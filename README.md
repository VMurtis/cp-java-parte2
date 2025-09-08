<img width="1597" height="856" alt="Captura de tela 2025-08-12 113226" src="<img width="800" height="430" alt="image" src="https://github.com/user-attachments/assets/b787e639-87ca-42df-add7-8449f9e47009" />
/>

# Integrantes:
Vinicius Murtinho Vicente Rm551151 
Lucas Barreto Consentino RM557107
Gustavo Bispo Cordeiro RM558515

---




## ⚙️ Tecnologias utilizadas

- ✅ Java 21
- ✅ Spring Boot
- ✅ Maven
- ✅ Oracle
- ✅ Postman


---


###  Método

- **Método:** `POST`
- **URL:**  
  `http://localhost:8081/ferramenta`

---

#### Body (JSON):

```json

{
  "nome": "Chave de Fenda",
  "tipo": "Manual",
  "tamanho": "Pequeno",
  "preco": 25.90
},

{
  "nome": "Martelo",
  "tipo": "Manual",
  "tamanho": "Médio",
  "preco": 45.00
},
{
  "nome": "Furadeira",
  "tipo": "Elétrica",
  "tamanho": "Grande",
  "preco": 320.50
}



```

###  Método

- **Método:** `PATCH`
- **URL:**  
  `http://localhost:8081/ferramenta/{id}`

---

#### Body (JSON):

```json
{
  "nome": "Chave de Fenda",
  "tipo": "Manual",
  "tamanho": "Pequeno",
  "preco": 30.00
}

```

###  Método

- **Método:** `GET`
- **URL:**  
  `http://localhost:8081/ferramenta/{id}`
  `http://localhost:8081/fornecedor/cnpj/{cnpj}`

---

###  Método

- **Método:** `DELETE`
- **URL:**  
  `http://localhost:8081/ferramenta/{id}`

---

---


###  Método

- **Método:** `POST`
- **URL:**  
  `http://localhost:8081/fornecedor`

---

#### Body (JSON):

```json
{
  "nome": "Maxobra",
  "cnpj": "12345678000199",
  "email": "maxobra@empresa.com",
  "telefone": "(11) 99999-9999"
},

{
  "nome": "Construtec",
  "cnpj": "11222333000155",
  "email": "contato@construtec.com",
  "telefone": "(11) 98888-7777"
},

{
  "nome": "ObraBase",
  "cnpj": "99887766000144",
  "email": "suporte@obrabase.com",
  "telefone": "(21) 97777-6666"
}




```

###  Método

- **Método:** `PATCH`
- **URL:**  
  `http://localhost:8081/fornecedor/{id}`

---

#### Body (JSON):

```json
{
  "email": "maxmail@empresa.com",
  "telefone": "(11) 98888-7777"
}



{
  "email": "outroemail@empresa.com"
  
}

{
  "telefone": "(11) 97777-3333"
}

```

###  Método

- **Método:** `GET`
- **URL:**  
  `http://localhost:8081/fornecedor/{id}`

---

###  Método

- **Método:** `DELETE`
- **URL:**  
  `http://localhost:8081/fornecedor/{id}`

---

---


###  Método

- **Método:** `POST`
- **URL:**  
  `http://localhost:8081/cliente`

---

#### Body (JSON):

```json
{
  "nome": "Ana Silva",
  "cpf": "12345678900",
  "email": "anaSilva@email.com",
  "telefone": "1178787878"
},

{
  "nome": "Carlos Mendes",
  "cpf": "98765432100",
  "email": "carlos.mendes@email.com",
  "telefone": "11999998888"
},
{
  "nome": "Fernanda Oliveira",
  "cpf": "45678912300",
  "email": "fernanda.oliveira@email.com",
  "telefone": "21988887777"
}





```

###  Método

- **Método:** `PATCH`
- **URL:**  
  `http://localhost:8081/cliente/{id}`

---

#### Body (JSON):

```json
{
  "email": "silvaAna@email.com"
}

{
  "email": "oliveiraa.fernanda@email.com"
}


{
  "telefone": "11911112222"
}


{
  "nome": "Ana Maria Silva",
  "email": "ana.maria@email.com"
}


```

###  Método

- **Método:** `GET`
- **URL:**  
  `http://localhost:8081/cliente/{id}`
  `http://localhost:8081/cliente/cpf/{cpf}`

---

###  Método

- **Método:** `DELETE`
- **URL:**  
  `http://localhost:8081/cliente/{id}`

---


