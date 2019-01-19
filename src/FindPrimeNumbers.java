
public class FindPrimeNumbers {

	public static void main(String[] args) {
		/*
		 * 指定の範囲の数値に対し素数であるものを表示する。
		 */
		FindPrimeNumbers findPrimeNumbers = new FindPrimeNumbers(1, 100);
		findPrimeNumbers.find();
	}
	
	private int start;
	private int end;
	
	/**
	 * コンストラクタ
	 * @param start … 評価開始値
	 * @param end … 評価終了値
	 */
	public FindPrimeNumbers(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	
	/**
	 * 与えた初期値に対し素数を探す。
	 */
	private void find()
	{
		if(this.start > this.end)
		{
			// 開始終了が対象逆の場合、価路入れ替える。
			int temp = this.start;
			this.start = this.end;
			this.end = temp;
		}
		
		/*
		 * 評価値の小さいほうから順番に素数かどうか判定し、素数なら表示する。
		 */
		for(int i = start; i <= end; i++)
		{
			if(isPrimeNumber(i))
			{
				System.out.println(i);
			}
		}
	}
	
	/**
	 * 評価対象の値が素数か否かを判定する。
	 * ・評価対象が以下は素数でない。
	 * ・評価対象に対し1から順に除数（商＞1、余り＝0）の有無を調べ
	 * 　1、評価対象以外の除数が見つかった場合…素数でないと判断
	 * 　1、評価対象以外の除数が見つからなかった場合、素数と判断
	 * 
	 * @param target … 評価対象の整数
	 * @return true … 評価対象が素数である。false … 評価対象が素数でない。
	 */
	boolean isPrimeNumber(int target)
	{
		/*
		 * 1以下は素数でないとみなす。
		 */
		if(target <= 1)
		{
			// 評価対象が1以下
			return false;
		}

		/*
		 * 1から順に除数の有無を調べる
		 */
		for(int i = 1; i <= target; i++ )
		{
			if( (target / i > 0) && (target % i == 0) )
			{
				// 除数が見つかった
				if( (i != 1) && (i != target) )
				{
					// 序数が1、評価対象以外 ⇒ 素数でない
					return false;
				}
			}
		}
		return true;
	}

}
