package com.rodcut.model;

import java.util.List;

public interface RodCuttingStrategy {
		
	 List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) ;
	 
	 double getMaximumRevenue(int totalLength, List<Rod> rodList) ;
}
