package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy{
	private int pageNum, pageSize, blockSize, 
			startRow, endRow, startPage, endPage,
			prevBlock, nextBlock, totalcount;
	private boolean existprev, existNext;

	
	@Override
	public void carryOut(Object o) {
		HttpServletRequest request = (HttpServletRequest)o;
		System.out.println("프록시 페이지네이션 도착");
		String _pageNum = request.getParameter("page_num");
		pageNum = (request.getParameter("page_num")==null)?1: Integer.parseInt(_pageNum);
		
		String _pageSize = request.getParameter("page_size");
		pageSize = (_pageSize==null)?5:Integer.parseInt(_pageSize);
		System.out.println("pageSize:::"+this.pageSize);
		
		
		
		totalcount = CustomerServiceImpl.getInstance().countCustomer(null);
		System.out.println("totalcount:::"+this.totalcount);
		
		//this.startRow = String.valueOf(totalcount-Integer.parseInt(this.pageSize));
		//this.endRow = String.valueOf(Integer.parseInt(this.startRow) +Integer.parseInt(this.pageSize)) ;  
		System.out.println("pageNUM??"+pageNum);
		System.out.println("pageSize??"+pageSize);
	
		/*
		 * startRow = (totalcount-((pageSize*pageNum)-1)); 
		 * endRow = ((totalcount-((pageSize*pageNum)-1))+4);
		 */
		int count = totalcount / pageSize; 
		System.out.println("count의 나누기는?"+count);
		if(totalcount%pageSize != 0) {
			count = count+1;
		System.out.println("count의 나머지는?"+count);
		}
		int ex = count*pageSize;
		startRow = totalcount-(pageSize*pageNum)+1;
		endRow = startRow + pageSize-1;
		if(endRow<=0) { endRow = 0; }

		System.out.println("1. end:: "+ex);
		System.out.println("=== startrow:: "+startRow);
		
		System.out.println("=== row:: "+endRow);
		
		System.out.println("startRow:::"+startRow);
		System.out.println("endrow:::"+endRow);
		
		/* 선생님 답안 (sql문도 수정해야함.)
		 * 	System.out.println("전체 카운트: "+rowCount);
		 *  int pageCount = rowCount / pageSize;
		 *  System.out.println("전체 페이지수: "+pageCount);
		 *  startRow = (pageNum -1) *pageSize + 1;
		 *  System.out.println("스타트로우: "+startRow);
		 *  endRow = (rowCount > pageNum * pageSize)? pageNum * pageSize: rowCount;
		 *  System.out.println("엔드로우: "+endRow);
		*/
	}
	
}
