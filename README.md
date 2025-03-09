# DemoWebShop ---> By Mina_E minaeskarous1990@gmail.com
This is UI test automation for DemoWebShop website, testing features and functionalities

# Test Cases for Demo WebShop

## 1. Verify Homepage Loads Correctly(TC001)
- **Description**: Ensure the homepage loads with all images, banners, and sections properly displayed.
- **Precondition**: None.
- **Steps**: 
  1. Open the homepage URL: `https://demowebshop.tricentis.com/`.
  2. Observe the page and ensure that it loads fully.
  3. Check that all sections such as "Top Navigation Bar", "Banners", "Featured Products", and "Footer" are visible.
  4. Confirm that no images are broken and the page does not have any visible errors (e.g., 404 or 500).
- **Expected Result**: The homepage should load correctly without errors, and all sections should be visible and functional.

## 2. Verify Navigation Bar Links(TC002)
- **Description**: Ensure all navigation links in the header are working.
- **Precondition**: Homepage loaded successfully.
- **Steps**: 
  1. Open the homepage.
  2. Hover over or click each link in the navigation bar (Home, Catalog, Shopping Cart, etc.).
  3. Verify that each link directs to the correct corresponding page.
  4. Check that the page loads without errors and contains the expected content.
- **Expected Result**: Each link in the navigation bar should lead to the appropriate page, and the page should load successfully.

## 3. Verify Product Search Functionality(TC003)
- **Description**: Verify that the search bar returns correct results for a search query.
- **Precondition**: Homepage loaded successfully.
- **Steps**: 
  1. On the homepage, locate the search bar.
  2. Type a product name (e.g., "Laptop") into the search bar.
  3. Click the search icon or press Enter.
  4. Observe the search results and verify that relevant products related to "Laptop" appear.
  5. Ensure that the search results page loads without errors.
- **Expected Result**: The results should display relevant products based on the search query, such as a list of laptops.

