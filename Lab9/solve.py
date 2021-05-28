import angr #the main framework
import sys # for stdin

proj = angr.Project("./give_me_password")

state = proj.factory.entry_state()
simgr = proj.factory.simulation_manager(state)
simgr.use_technique(angr.exploration_techniques.DFS())

# 1
avoid_addr = [0x400970, 0x400713]
find_addr = 0x4009e3 # corrent & get stdout -> correct
simgr.explore(find=find_addr, avoid=avoid_addr)

found = simgr.found[0] # A state that reached the find condition from explore
print("password (stdin) :")
print(found.posix.dumps(sys.stdin.fileno()))
print("out message (stdout) :")
print(found.posix.dumps(sys.stdout.fileno()))




