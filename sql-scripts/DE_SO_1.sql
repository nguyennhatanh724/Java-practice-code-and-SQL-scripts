-- Bài 1
SELECT * FROM products
WHERE price > 100;

-- Bài 2
SELECT name, price FROM products
WHERE category = 'Điện tử'
ORDER BY price DESC;

-- Bài 3
SELECT category, COUNT(*) AS total_products
FROM products
GROUP BY category;
