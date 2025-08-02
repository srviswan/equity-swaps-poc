package cdm.product.template.util;

import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import cdm.product.template.TransferableProduct;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class ProductDeepPathUtil {
	public EconomicTerms chooseEconomicTerms(Product product) {
		final MapperS<TransferableProduct> transferableProduct = MapperS.of(product).<TransferableProduct>map("getTransferableProduct", _product -> _product.getTransferableProduct());
		if (exists(transferableProduct).getOrDefault(false)) {
			return transferableProduct.<EconomicTerms>map("getEconomicTerms", _transferableProduct -> _transferableProduct.getEconomicTerms()).get();
		}
		final MapperS<NonTransferableProduct> nonTransferableProduct = MapperS.of(product).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct());
		if (exists(nonTransferableProduct).getOrDefault(false)) {
			return nonTransferableProduct.<EconomicTerms>map("getEconomicTerms", _nonTransferableProduct -> _nonTransferableProduct.getEconomicTerms()).get();
		}
		return null;
	}
	
}
