package day2;

import java.util.*;

public class Solution {
    //括号匹配
    public boolean valid(String strs) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < strs.length(); i++) {
            char ch = strs.charAt(i);
            if (s.empty() || !s.peek().equals(map.get(ch))) {
                s.push(ch);
            } else {
                s.pop();
            }
        }
        return s.empty();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //有序链表合并
    public ListNode mergerTwoList(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if (l1 == null) {
            res.next = l2;
        } else {
            res.next = l1;
        }
        return res.next;
    }

    //数组内相同数字除去
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //数组内特定值除去
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length - 1;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] tmp = new int[length];
        int min = Math.min(nums1.length, nums2.length);
        int i = 0, j = 0, s = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                tmp[s] = nums1[i];
                i++;
            } else {
                tmp[s] = nums2[j];
                j++;
            }
            s++;
        }
        if (i == nums1.length) {
            while (s < length) {
                tmp[s] = nums2[j];
                s++;
                j++;
            }
        } else {
            while (s < length) {
                tmp[s] = nums1[i];
                s++;
                i++;
            }
        }
        return length % 2 == 0 ? (tmp[length / 2 - 1] + tmp[length / 2]) / 2.0 : tmp[length / 2];
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int l = 0, r = height.length, m = 0;
        while (l < r) {
            m = Math.max(m, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return m;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int l = i+1, r = nums.length -1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    List<Integer> rel = new ArrayList<>();
                    rel.add(nums[i]);
                    rel.add(nums[l]);
                    rel.add(nums[r]);
                    res.add(rel);

                    l++;
                    r--;
                } else {
                    if(sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            twoSumHelper(nums, left, right, target, res);
        }

        return res;
    }

    public List<List<Integer>> twoSumHelper(int[] nums,
                                            int left,
                                            int right,
                                            int target,
                                            List<List<Integer>> result) {
        while (left < right) {
            if (target == nums[left] + nums[right]) {
                List<Integer> tripletList = new ArrayList();
                tripletList.add(-target);
                tripletList.add(nums[left]);
                tripletList.add(nums[right]);
                result.add(tripletList);

                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (target > nums[left] + nums[right]) {
                left++;
            } else if (target < nums[left] + nums[right]) {
                right--;
            }


        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                } else {
                    if(Math.abs(sum - target) < Math.abs(target - closest)) {
                        closest = sum;
                    } else {
                        if(sum > target) {
                            r--;
                        } else {
                            l++;
                        }
                    }
                }
            }
        }
        return closest;
    }

    public int removeElement1(int[] nums, int val) {
        if(nums == null || nums.length ==0) {
            return 0;
        }
        int i=0;
        for(int j=1; j<nums.length -1; j++) {
            if(nums[i] == val) {
                nums[i] = nums[j];
                i++;
            } else {
                i++;
            }
        }
        return i;
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length, s = 0, e = n - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(nums[m] == target) {
                return m;
            }
            if(nums[m] >= nums[s]) {
                if(target < nums[m] && target >= nums[s]) {
                    e = m-1;
                } else {
                    s = m + 1;
                }
            } else {
                if(target > nums[m] && target <= nums[e]) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        for(int i=0; i< nums.length; i++) {
            if(nums[i] == target){
                nums[0] = i;
                break;
            }
        }

        if(res[0] == -1) {
            return res;
        }

        for(int j= nums.length - 1; j >= 0; j++) {
            if(nums[j] == target) {
                res[1] = j;
                break;
            }
        }

        return res;
    }


    public int[] searchRange2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                low = mid; high = mid;
                while (low >= 1 && nums[low] == nums[low - 1]) low--; // extends the low edge
                if (nums[0] == nums[low]) low = 0;
                while (high < nums.length - 1 && nums[high] == nums[high + 1]) high++; // extends the high edge
                if (nums[high] == nums[nums.length - 1]) high = nums.length - 1;
                return new int[] {low, high};
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }


    public int searchInsert(int[] nums, int target) {
//        int low = 0, high = A.length-1;
//        while(low<=high){
//            int mid = (low+high)/2;
//            if(A[mid] == target) return mid;
//            else if(A[mid] > target) high = mid-1;
//            else low = mid+1;
//        }
//        return low;

        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationHelper(candidates, target, 0,  new ArrayList<Integer>(), res);
        return res;
    }

    public void combinationHelper(int[] candidates,
                                  int target,
                                  int start,
                                  List<Integer> sumList,
                                  List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(sumList));
        } else if(target < 0) {
            return;
        } else if(target > 0) {
            for(int i=start; i<candidates.length; i++) {
                sumList.add(candidates[i]);
                combinationHelper(candidates, target - candidates[i], i, sumList, res);
                sumList.remove(sumList.size() - 1);
            }
        }
    }

    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        for(int i=0; i< nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for(int i=0; i< nums.length; i++) {
            if(nums[i] != i + 1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }

    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g)
                bulls++;
            else {
                if (map[s] < 0)//guess里有多余的，因为小于0只可能是guess造成的
                    cows++;
                if (map[g] > 0)//secret里有多余的，因为大于0只可能是secret造成的
                    cows++;
                map[s]++;
                map[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }


}
