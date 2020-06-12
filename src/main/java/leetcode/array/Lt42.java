class Lt42 {
	public int trap1(int[] height) {
		if(null == height) return 0;
		
		int ans = 0;
		for(int i=1; i < height.length - 1; i++) {
			int left = height[i], right = height[i];
			for(int l = i-1; l>=0; l--) {
				left = Math.max(left, height[l]);
			}
			for(int r = i+1; r<height.length; r++) {
				r = Math.max(right, height[r]);
			}
			
			ans += Math.min(left, right) - height[i];
		}
		return res;
    }
	
	/**
	*O(N * 3)  O(N)
	*/
	public int trap2(int[] height) {
		if(null == height) return 0;
		int[] leftMax = new int[height.length];
		leftMax[0] = height[0];
		for(int i=1; i<height.length; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i-1]);
		}
		
		int[] rightMax = new int[height.length];
		rightMax[height.length - 1] = height[height.length-1];
		for(int i=height.length - 2; i>=0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i+1]);
		}
		
		int ans = 0;
		for(int i=1; i<height.length-1; i++) {
			ans += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return ans;
	}
	
}


使用栈来存储条形块的索引下标。
遍历数组：
当栈非空且 \text{height}[current]>\text{height}[st.top()]height[current]>height[st.top()]
意味着栈中元素可以被弹出。弹出栈顶元素 \text{top}top。
计算当前元素和栈顶元素的距离，准备进行填充操作
\text{distance} = \text{current} - \text{st.top}() - 1distance=current−st.top()−1
找出界定高度
\text{bounded\_height} = \min(\text{height[current]}, \text{height[st.top()]}) - \text{height[top]}bounded_height=min(height[current],height[st.top()])−height[top]
往答案中累加积水量\text{ans} \mathrel{+}= \text{distance} \times \text{bounded\_height}ans+=distance×bounded_height
将当前索引下标入栈
将 \text{current}current 移动到下个位置
C++

int trap(vector<int>& height)
{
    int ans = 0, current = 0;
    stack<int> st;
    while (current < height.size()) {
        while (!st.empty() && height[current] > height[st.top()]) {
            int top = st.top();
            st.pop();
            if (st.empty())
                break;
            int distance = current - st.top() - 1;
            int bounded_height = min(height[current], height[st.top()]) - height[top];
            ans += distance * bounded_height;
        }
        st.push(current++);
    }
    return ans;
}


int trap(vector<int>& height)
{
    int left = 0, right = height.size() - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
            ++left;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            --right;
        }
    }
    return ans;
}

public int trap(int[] height) {
	int leftMax = 0;
	int rightMax = 0;
	int ans = 0;
	int left = 0;
	int right = height.length - 1;
	
	while(left < right) {
		if(height[left] > height[right]) {
			//right
			if(height[right] > rightMax) rightMax = height[right];
			else ans += rightMax - height[right];
			right--;
		} else { 
			if(height[left] > leftMax) leftMax = height[left];
			else ans += leftMax - height[left];
			left++;
		}
	}
	return ans;
}